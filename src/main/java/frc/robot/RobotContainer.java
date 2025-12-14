// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.Seconds;

import java.util.Map;
import java.util.Set;

import com.frcteam3255.joystick.SN_XboxController;

import choreo.auto.AutoFactory;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.DeferredCommand;
import frc.robot.RobotMap.mapControllers;
import frc.robot.commands.states.Climbing;
import frc.robot.commands.states.ColorRotatingPanel;
import frc.robot.commands.states.Intaking;
import frc.robot.commands.states.PrepClimb;
import frc.robot.commands.states.PrepCloseTrench;
import frc.robot.commands.states.PrepFarTrench;
import frc.robot.commands.states.PrepInitLine;
import frc.robot.commands.states.PrepPanel;
import frc.robot.commands.states.PrepPowerPort;
import frc.robot.commands.states.Shooting;
import frc.robot.commands.states.TripleRotatingPanel;
import frc.robot.constants.ConstSystem.constControllers;
import frc.robot.subsystems.*;
import frc.robot.subsystems.DriverStateMachine.DriverState;
import frc.robot.subsystems.StateMachine.RobotState;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.epilogue.NotLogged;

@Logged
public class RobotContainer {

  @NotLogged
  SendableChooser<Command> autoChooser = new SendableChooser<>();

  private AutoFactory autoFactory;

  private final SN_XboxController conDriver = new SN_XboxController(mapControllers.DRIVER_USB);
  private final SN_XboxController conOperator = new SN_XboxController(mapControllers.OPERATOR_USB);

  private final Drivetrain subDrivetrain = new Drivetrain();
  public final static Rotors rotorsInstance = new Rotors();
  private final DriverStateMachine subDriverStateMachine = new DriverStateMachine(subDrivetrain);
  private final StateMachine subStateMachine = new StateMachine(subDrivetrain);
  private final RobotPoses robotPose = new RobotPoses(subDrivetrain);
  public static final Motion motionInstance = new Motion();
  Command TRY_NONE = Commands.deferredProxy(
      () -> subStateMachine.tryState(RobotState.NONE));

  Command MANUAL = new DeferredCommand(
      subDriverStateMachine.tryState(
          DriverStateMachine.DriverState.MANUAL,
          conDriver.axis_LeftY,
          conDriver.axis_LeftX,
          conDriver.axis_RightX,
          conDriver.btn_RightBumper),
      Set.of(subDriverStateMachine));

  Command EXAMPLE_POSE_DRIVE = new DeferredCommand(
      subDriverStateMachine.tryState(
          DriverStateMachine.DriverState.EXAMPLE_POSE_DRIVE,
          conDriver.axis_LeftY,
          conDriver.axis_LeftX,
          conDriver.axis_RightX,
          conDriver.btn_RightBumper),
      Set.of(subDriverStateMachine));

  public RobotContainer() {
    conDriver.setLeftDeadband(constControllers.DRIVER_LEFT_STICK_DEADBAND);

    subDriverStateMachine
        .setDefaultCommand(MANUAL);

    autoFactory = new AutoFactory(
        subDrivetrain::getPose, // A function that returns the current robot pose
        subDrivetrain::resetPoseToPose, // A function that resets the current robot pose to the provided Pose2d
        subDrivetrain::followTrajectory, // The drive subsystem trajectory follower
        true, // If alliance flipping should be enabled
        subDriverStateMachine // The drive subsystem
    );

    configDriverBindings();
    configOperatorBindings();
    configAutonomous();

    subDrivetrain.resetModulesToAbsolute();
  }

  private void configDriverBindings() {
    conDriver.btn_B.onTrue(Commands.runOnce(() -> subDrivetrain.resetModulesToAbsolute()));
    conDriver.btn_North
        .onTrue(Commands.runOnce(() -> subDrivetrain.resetPoseToPose(new Pose2d(0, 0, new Rotation2d()))));

    // Defaults to Field-Relative, is Robot-Relative while held
    conDriver.btn_LeftBumper
        .whileTrue(Commands.runOnce(() -> subDrivetrain.setRobotRelative()))
        .onFalse(Commands.runOnce(() -> subDrivetrain.setFieldRelative()));

    // Example Pose Drive
    conDriver.btn_X
        .whileTrue(EXAMPLE_POSE_DRIVE)
        .onFalse(Commands.runOnce(() -> subDriverStateMachine.setDriverState(DriverState.MANUAL)));

    conDriver.btn_Start.whileTrue(new PrepClimb());
    conDriver.btn_Back.whileTrue(new Climbing());
  }

  public void configAutonomous() {
    Command PP3CellReverse = Commands.sequence(
        new PrepInitLine().withTimeout(.5),
        new Shooting().withTimeout(.5),
        runPath("InitPP_OffInitPP").asProxy()

    );

    Command Trench6Cell = Commands.sequence(
        new PrepInitLine().withTimeout(.5),
        new Shooting().withTimeout(.5),
        runPath("InitTrench_ControlPanel").alongWith(new Intaking().withTimeout(.5)).asProxy(),
        runPath("ControlPanel_InitTrench").asProxy(),
        new Shooting().withTimeout(.5));

    autoChooser.setDefaultOption("PP3CellReverse", PP3CellReverse);
    autoChooser.addOption("Trench6Cell", Trench6Cell);

    Map<Command, String> autoStartingPoses = Map.ofEntries(
        Map.entry(PP3CellReverse, "InitPP_OffInitPP"),
        Map.entry(Trench6Cell, "InitTrench_ControlPanel"));

    autoChooser.onChange(selectedAuto -> {
      String startingPose = autoStartingPoses.get(selectedAuto);
      if (startingPose != null) {
        autoFactory.resetOdometry(startingPose)
            .ignoringDisable(true)
            .schedule();
      }
    });

    // Example: Add autonomous routines to the chooser
    autoChooser.setDefaultOption("Do Nothing", Commands.none());
    autoChooser.addOption("Example Path", runPath("ExamplePath"));
    // Add more autonomous routines as needed, e.g.:
    // autoChooser.addOption("Score and Leave", runPath("ScoreAndLeave"));

    SmartDashboard.putData("Auto Chooser", autoChooser);
  }

  public Command runPath(String pathName) {
    return autoFactory.trajectoryCmd(pathName).asProxy()
        .alongWith(Commands.runOnce(() -> subDriverStateMachine.setDriverState(DriverState.CHOREO)));
  }

  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }

  private void configOperatorBindings() {
    // Add operator bindings here if needed
    conOperator.btn_RightTrigger.whileTrue(new Shooting());
    conOperator.btn_LeftTrigger.whileTrue(new Intaking());
    conOperator.btn_Y.whileTrue(new PrepPowerPort());
    conOperator.btn_B.whileTrue(new PrepFarTrench());
    conOperator.btn_X.whileTrue(new PrepCloseTrench());
    conOperator.btn_West.whileTrue(new TripleRotatingPanel());
    conOperator.btn_East.whileTrue(new ColorRotatingPanel());
    conOperator.btn_North.whileTrue(new PrepPanel());

  }

  public RobotState getRobotState() {
    return subStateMachine.getRobotState();
  }
}
