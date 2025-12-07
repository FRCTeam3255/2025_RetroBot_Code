// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.MotionMagicExpoVoltage;
import com.ctre.phoenix6.controls.MotionMagicExpoVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.constants.ConstMotion;
// import frc.robot.subsystems.Climber; // Ensure Climber class exists in this package
// Uncomment and adjust the import below if Climber is in a different package
// import frc.robot.someotherpackage.Climber;

public class Motion extends SubsystemBase {
  /** Creates a new Motion. */
  final TalonFX hoodPivotMotor = new TalonFX(RobotMap.mapMotion.HOOD_CAN);
  final TalonFX intakePivotMotor = new TalonFX(RobotMap.mapMotion.INTAKE_PIVOT);

  MotionMagicExpoVoltage positionRequestHoodPivot = new MotionMagicExpoVoltage(0);
  final MotionMagicExpoVoltage intakePivotRequest = new MotionMagicExpoVoltage(0);

  public void setIntakePivotAngle(Angle targetAngle) {
    intakePivotMotor.setControl(intakePivotRequest.withPosition(targetAngle));
  }

  public Motion() {
    // Apply configuration to Climber motor

    // Apply configuration to Hood motor
    hoodPivotMotor.getConfigurator().apply(ConstMotion.HOOD_CONFIGURATION);
    intakePivotMotor.getConfigurator().apply(ConstMotion.INTAKE_PIVOT_CONFIGURATION);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setHoodAngle(Angle hoodAngle) {
    hoodPivotMotor.setControl(positionRequestHoodPivot.withPosition(hoodAngle));
  }
}
