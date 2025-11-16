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
  TalonFX intakeMotor;
  TalonFX funnelbeltMotor;

  public Rotors() {
    intakeMotor = new TalonFX(mapRotors.INTAKE_CAN);
    funnelbeltMotor = new TalonFX(mapRotors.FUNNELBELT_CAN);

    intakeMotor.getConfigurator().apply(ConstRotors.INTAKE_CONFIGURATION);
    funnelbeltMotor.getConfigurator().apply(ConstRotors.FUNNELBELT_CONFIGURATION);
  }

  public void setIntakeMotorSpeed(double speed) {
    intakeMotor.set(speed);
  }

  public void setFunnelbeltMotorSpeed(double speed) {
    funnelbeltMotor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
