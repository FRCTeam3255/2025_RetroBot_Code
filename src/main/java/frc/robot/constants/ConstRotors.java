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
  public static final TalonFXConfiguration FUNNELBELT_CONFIGURATION = new TalonFXConfiguration();
  static {

    // TODO: replace configurations with real values
    INTAKE_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    INTAKE_CONFIGURATION.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
    INTAKE_CONFIGURATION.CurrentLimits.SupplyCurrentLimitEnable = false;
    INTAKE_CONFIGURATION.CurrentLimits.SupplyCurrentLowerLimit = 30;
    INTAKE_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = 60;
    INTAKE_CONFIGURATION.CurrentLimits.SupplyCurrentLowerTime = 0.5;
    INTAKE_CONFIGURATION.SoftwareLimitSwitch.ForwardSoftLimitEnable = false;
    INTAKE_CONFIGURATION.SoftwareLimitSwitch.ReverseSoftLimitEnable = false;

    FUNNELBELT_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    FUNNELBELT_CONFIGURATION.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
    FUNNELBELT_CONFIGURATION.CurrentLimits.SupplyCurrentLimitEnable = false;
    FUNNELBELT_CONFIGURATION.CurrentLimits.SupplyCurrentLowerLimit = 30;
    FUNNELBELT_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = 60;
    FUNNELBELT_CONFIGURATION.CurrentLimits.SupplyCurrentLowerTime = 0.5;
    FUNNELBELT_CONFIGURATION.SoftwareLimitSwitch.ForwardSoftLimitEnable = false;
    FUNNELBELT_CONFIGURATION.SoftwareLimitSwitch.ReverseSoftLimitEnable = false;
  }

}
