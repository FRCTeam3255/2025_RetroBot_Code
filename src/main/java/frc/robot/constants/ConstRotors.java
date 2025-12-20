// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

import static edu.wpi.first.units.Units.RPM;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.units.measure.AngularVelocity;

/** Add your docs here. */
public class ConstRotors {
  public static final TalonFXConfiguration INTAKE_CONFIGURATION = new TalonFXConfiguration();
  public static final TalonFXConfiguration HOPPER_RIGHT_CONFIGURATION = new TalonFXConfiguration();
  public static final TalonFXConfiguration HOPPER_LEFT_CONFIGURATION = new TalonFXConfiguration();
  public static final TalonFXConfiguration FLYWHEEL_CONFIGURATION = new TalonFXConfiguration();
  public static final double HOPPER_RIGHT_MOTOR_SPEED = 1;
  public static final double HOPPER_LEFT_MOTOR_SPEED = 0;
  public static final double INTAKE_MOTOR_SPEED = 1;
  public static final double EJECT_MOTOR_SPEED = -1;
  public static final AngularVelocity FLYWHEEL_SPEED = RPM.of(1);
  public static final TalonFXConfiguration TRANSFER_CONFIGURATION = new TalonFXConfiguration();
  public static final double TRANSFER_SPEED = 1;
  public static final double EXTEND_CLIMBER_MOTOR_SPEED = 0.5;
  public static final double STOP_CLIMBER_MOTOR = 0;
  public static final double RETRACT_CLIMBER_MOTOR_SPEED = -0.5;
  public static final TalonFXConfiguration CLIMBER_CONFIGURATION = new TalonFXConfiguration();

  static {

    // TODO: replace configurations with real values
    INTAKE_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    INTAKE_CONFIGURATION.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;

    HOPPER_RIGHT_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    HOPPER_RIGHT_CONFIGURATION.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

    HOPPER_LEFT_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Coast;
    HOPPER_LEFT_CONFIGURATION.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

    FLYWHEEL_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Coast;
    FLYWHEEL_CONFIGURATION.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

    CLIMBER_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    CLIMBER_CONFIGURATION.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;

    FLYWHEEL_CONFIGURATION.Slot0.kS = 0; 
    FLYWHEEL_CONFIGURATION.Slot0.kV = 0;
    FLYWHEEL_CONFIGURATION.Slot0.kS = 0; 
    FLYWHEEL_CONFIGURATION.Slot0.kV = 0;
    FLYWHEEL_CONFIGURATION.Slot0.kA = 0;
    FLYWHEEL_CONFIGURATION.Slot0.kP = 0;
    
    FLYWHEEL_CONFIGURATION.MotionMagic.MotionMagicCruiseVelocity = 60;
    FLYWHEEL_CONFIGURATION.MotionMagic.MotionMagicAcceleration = 600;
    FLYWHEEL_CONFIGURATION.MotionMagic.MotionMagicJerk = 6000;
  
  }

}
