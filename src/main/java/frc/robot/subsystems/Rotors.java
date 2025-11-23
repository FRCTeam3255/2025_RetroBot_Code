// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap.mapRotors;
import frc.robot.constants.ConstRotors;

public class Rotors extends SubsystemBase {
  /** Creates a new Rotors. */
  final TalonFX intakeMotor = new TalonFX(mapRotors.INTAKE_CAN);
  final TalonFX hopperRightMotor = new TalonFX(mapRotors.HOPPER_RIGHT_CAN);
  final TalonFX hopperLeftMotor = new TalonFX(mapRotors.HOPPER_LEFT_CAN);
  final TalonFX flywheelMotor = new TalonFX(mapRotors.FLYWHEEL_CAN);

  public Rotors() {
    intakeMotor.getConfigurator().apply(ConstRotors.INTAKE_CONFIGURATION);
    hopperRightMotor.getConfigurator().apply(ConstRotors.HOPPER_RIGHT_CONFIGURATION);
    hopperLeftMotor.getConfigurator().apply(ConstRotors.HOPPER_LEFT_CONFIGURATION);
    flywheelMotor.getConfigurator().apply(ConstRotors.FLYWHEEL_CONFIGURATION);
  }

  public void setIntakeMotorSpeed(double speed) {
    intakeMotor.set(speed);
  }

  public void setFunnelBeltMotorSpeed(double speed) {
    hopperRightMotor.set(speed);
  }

  public void setFlywheelMotorSpeed(double speed) {
    flywheelMotor.set(speed);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
