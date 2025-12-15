// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.MotionMagicVelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.RobotMap.mapRotors;
import frc.robot.constants.ConstRotors;

@Logged
public class Rotors extends SubsystemBase {
  /** Creates a new Rotors. */
  final TalonFX intakeMotor = new TalonFX(mapRotors.INTAKE_CAN);
  final TalonFX rightHopperMotor = new TalonFX(mapRotors.HOPPER_RIGHT_CAN);
  final TalonFX leftHopperMotor = new TalonFX(mapRotors.HOPPER_LEFT_CAN);
  final TalonFX rightflywheelMotor = new TalonFX(mapRotors.RIGHT_FLYWHEEL_CAN);
  final TalonFX leftflywheelMotor = new TalonFX(mapRotors.LEFT_FLYWHEEL_CAN);
  final TalonSRX transferMotor = new TalonSRX(mapRotors.TRANSFER_CAN);
  final TalonFX climber = new TalonFX(RobotMap.mapRotors.CLIMBER_CAN);

  public Rotors() {
    intakeMotor.getConfigurator().apply(ConstRotors.INTAKE_CONFIGURATION);
    rightHopperMotor.getConfigurator().apply(ConstRotors.HOPPER_RIGHT_CONFIGURATION);
    leftHopperMotor.getConfigurator().apply(ConstRotors.HOPPER_LEFT_CONFIGURATION);
    rightflywheelMotor.getConfigurator().apply(ConstRotors.FLYWHEEL_CONFIGURATION);
    leftflywheelMotor.getConfigurator().apply(ConstRotors.FLYWHEEL_CONFIGURATION);
    transferMotor.configFactoryDefault();
    climber.getConfigurator().apply(ConstRotors.CLIMBER_CONFIGURATION);
  }

  final MotionMagicVelocityVoltage flywheelVelocityRequest = new MotionMagicVelocityVoltage(0);

  public void setIntakeMotorPower(double power) {
    intakeMotor.set(power);
  }

  public void setHopperRightMotorPower(double power) {
    rightHopperMotor.set(power);
  }

  public void setHopperLeftMotorPower(double power) {
    leftHopperMotor.set(power);

  }

  public void setFlywheelMotorPower(AngularVelocity speed) {
    rightflywheelMotor.setControl(flywheelVelocityRequest.withVelocity(speed));
    leftflywheelMotor.setControl(new Follower(rightflywheelMotor.getDeviceID(), true));
  }

  public void setTransferMotorPower(double power) {
    transferMotor.set(ControlMode.PercentOutput, power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setClimberPower(double power) {
    climber.set(power);

  }

}
