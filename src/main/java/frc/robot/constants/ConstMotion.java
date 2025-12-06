// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

/** Add your docs here. */
public class ConstMotion {

  public static final double EXTEND_CONTROLPANEL_MOTOR_SPEED = 0.5;

  public static final double EXTEND_CLIMBER_MOTOR_SPEED = 0.5;

  public static final double STOP_CLIMBER_MOTOR = 0;

  public static final double RETRACT_CLIMBER_MOTOR_SPEED = -0.5;

  public static final double ANGLE_HOOD_SPEED = 0.5;

  public static final double COLOR_ROTATING_PANEL_SPEED = 0.5;

  public static final double TRIPLE_ROTATING_PANEL_SPEED = 0.3;

  public static final TalonFXConfiguration CLIMBER_CONFIGURATION = new TalonFXConfiguration();

  public static final TalonFXConfiguration HOOD_CONFIGURATION = new TalonFXConfiguration();
  static {
    CLIMBER_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    CLIMBER_CONFIGURATION.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;

    HOOD_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    HOOD_CONFIGURATION.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
  }
}
