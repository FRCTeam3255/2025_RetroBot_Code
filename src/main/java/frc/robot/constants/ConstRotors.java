// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

/** Add your docs here. */
public class ConstRotors {
  public static final TalonFXConfiguration INTAKE_CONFIGURATION = new TalonFXConfiguration();
  public static final TalonFXConfiguration FUNNEL_BELT_CONFIGURATION = new TalonFXConfiguration();
  public static final TalonFXConfiguration FLYWHEEL_CONFIGURATION = new TalonFXConfiguration();
  public static final double FUNNEL_BELT_SPEED = 0.5;
  public static final double INTAKE_MOTOR_SPEED = 0.5;
  public static final double FLYWHEEL_SPEED = 1;
  public static final TalonFXConfiguration TRANSFER_CONFIGURATION = new TalonFXConfiguration();
  public static final double TRANSFER_SPEED = 0.5;
  {

    // TODO: replace configurations with real values
    INTAKE_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    INTAKE_CONFIGURATION.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;

    FUNNEL_BELT_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    FUNNEL_BELT_CONFIGURATION.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;

    FLYWHEEL_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Coast;
    FLYWHEEL_CONFIGURATION.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
  }

}
