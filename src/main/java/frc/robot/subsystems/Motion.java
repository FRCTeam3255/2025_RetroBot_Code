// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.constants.ConstMotion;
// import frc.robot.subsystems.Climber; // Ensure Climber class exists in this package
// Uncomment and adjust the import below if Climber is in a different package
// import frc.robot.someotherpackage.Climber;

public class Motion extends SubsystemBase {
  /** Creates a new Motion. */
  final TalonFX Climber = new TalonFX(RobotMap.mapMotion.CLIMBER_CAN);
  final TalonFX Hood = new TalonFX(RobotMap.mapMotion.HOOD_CAN);
  final TalonFX controlPanelWheelMotor = new TalonFX(RobotMap.mapMotion.CONTROL_PANEL_WHEEL_CAN);

  public Motion() {
   
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setControlPanelSpeed(double speed) {
    controlPanelWheelMotor.set(speed);

  }

  public void extendClimber(double speed) {
    Climber.set(speed);

  }

  public void stopClimb() {
    Climber.set(ConstMotion.STOP_CLIMBER_MOTOR);
  }

  public void retractClimber(double speed) {
    Climber.set(speed);
  }

  public void angleHood(double speed){
    Hood.set(speed);
  }
}
