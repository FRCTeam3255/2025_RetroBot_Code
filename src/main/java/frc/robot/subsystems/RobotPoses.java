// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.epilogue.NotLogged;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.units.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.constants.ConstSystem;

@Logged
public class RobotPoses extends SubsystemBase {
  /** Creates a new RobotPoses. */

  @NotLogged
  Drivetrain subDrivetrain;

  Pose3d modelDrivetrain = Pose3d.kZero;
  Pose3d model0Pivot = Pose3d.kZero;

  Rotation3d pivotRotation3d;
  Transform3d pivotPoint = new Transform3d(
      Units.Inches.zero(),
      Units.Inches.of(16),
      Units.Inches.zero(),
      Rotation3d.kZero);

  public RobotPoses(Drivetrain subDrivetrain) {
    this.subDrivetrain = subDrivetrain;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // Robot Positions

    pivotRotation3d = new Rotation3d(
        RobotContainer.motionInstance.getPivotAngle(),
        Units.Degrees.zero(),
        Units.Degrees.zero());

    modelDrivetrain = new Pose3d(subDrivetrain.getPose());
    model0Pivot = Pose3d.kZero.rotateAround(model0Pivot.plus(pivotPoint).getTranslation(), pivotRotation3d)
        .rotateBy(new Rotation3d(
            Units.Degrees.zero(),
            Units.Degrees.zero(),
            Units.Degrees.of(-90)));
  }
}
