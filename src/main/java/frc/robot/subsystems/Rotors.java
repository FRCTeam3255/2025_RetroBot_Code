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
  final TalonFX funnelBeltMotor = new TalonFX(mapRotors.FUNNELBELT_CAN);

  public Rotors() {
    intakeMotor.getConfigurator().apply(ConstRotors.INTAKE_CONFIGURATION);
    funnelBeltMotor.getConfigurator().apply(ConstRotors.FUNNELBELT_CONFIGURATION);
  }

  public void setIntakeMotorSpeed(double speed) {
    intakeMotor.set(speed);
  }

  public void setFunnelbeltMotorSpeed(double speed) {
    funnelBeltMotor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
