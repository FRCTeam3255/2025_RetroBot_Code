// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

import static edu.wpi.first.units.Units.Degrees;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.units.measure.Angle;

/** Add your docs here. */
public class ConstMotion {

  public static final double INTAKE_PIVOT = 0.5;

  public static final Angle HOOD_ANGLE_PCT = Degrees.of(1);

  public static final Angle HOOD_ANGLE_PFT = Degrees.of(0.5);

  public static final Angle HOOD_ANGLE_PPP = Degrees.of(0.7);

  public static final double COLOR_ROTATING_PANEL_POWER = 0.5;
  
  public static final Angle HOOD_ANGLE_PIL = Degrees.of(.67);

  public static final double TRIPLE_ROTATING_PANEL_POWER = 0.3;

  public static final TalonFXConfiguration HOOD_CONFIGURATION = new TalonFXConfiguration();

  public static final TalonFXConfiguration INTAKE_PIVOT_CONFIGURATION = new TalonFXConfiguration();

  public static final Angle PANEL_ANGLE = Degrees.of(0);

  public static final Angle RETRACT_INTAKE_ANGLE = Degrees.of(0);

  public static final Angle DEPLOY_INTAKE_ANGLE = Degrees.of(100);

  static {

    HOOD_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    HOOD_CONFIGURATION.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;

    INTAKE_PIVOT_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    INTAKE_PIVOT_CONFIGURATION.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

    INTAKE_PIVOT_CONFIGURATION.Slot0.kS = 0.2;
    INTAKE_PIVOT_CONFIGURATION.Slot0.kG = -.1;

    INTAKE_PIVOT_CONFIGURATION.Slot0.kP = 50;

    INTAKE_PIVOT_CONFIGURATION.Slot0.GravityType = GravityTypeValue.Arm_Cosine;

    INTAKE_PIVOT_CONFIGURATION.Feedback.SensorToMechanismRatio = 1. / ((10. / 54.) * (20. / 72.) * (14. / 38.));
    // WE ARE GOING TO TUNE TS LATER :fire:
    HOOD_CONFIGURATION.Slot0.kS = 0;
    HOOD_CONFIGURATION.Slot0.kG = 0;
    HOOD_CONFIGURATION.Slot0.kP = 0;
    HOOD_CONFIGURATION.Slot0.GravityType = GravityTypeValue.Arm_Cosine;
    HOOD_CONFIGURATION.Feedback.SensorToMechanismRatio = ((12.0 / 30.0) * (10.0 / 140.0));

  }
}
