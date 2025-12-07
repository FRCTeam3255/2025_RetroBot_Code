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

  public static final double ANGLE_HOOD_SPEED = 0.5;

  public static final double COLOR_ROTATING_PANEL_SPEED = 0.5;

  public static final double TRIPLE_ROTATING_PANEL_SPEED = 0.3;

  public static final TalonFXConfiguration HOOD_CONFIGURATION = new TalonFXConfiguration();

  public static final TalonFXConfiguration INTAKE_PIVOT_CONFIGURATION = new TalonFXConfiguration();

  public static final Angle PANEL_ANGLE = Degrees.of(0);

  public static final Angle RETRACT_INTAKE_ANGLE = Degrees.of(0);

  public static final Angle DEPLOY_INTAKE_ANGLE = Degrees.of(0);

  static {

    HOOD_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    HOOD_CONFIGURATION.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;

    INTAKE_PIVOT_CONFIGURATION.Slot0.kS = 0;
    INTAKE_PIVOT_CONFIGURATION.Slot0.kG = 0;

    INTAKE_PIVOT_CONFIGURATION.Slot0.kP = 0;

    INTAKE_PIVOT_CONFIGURATION.Slot0.GravityType = GravityTypeValue.Arm_Cosine;

    INTAKE_PIVOT_CONFIGURATION.Feedback.SensorToMechanismRatio = ((10 / 54) * (20 / 72) * (14 / 38));

  }
}
