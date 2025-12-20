package frc.robot.commands.states;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.constants.ConstMotion;
import frc.robot.constants.ConstRotors;;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class Eject extends Command {
  /** Creates a new Intaking. */
  public Eject() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.rotorsInstance.setIntakeMotorSpeed(ConstRotors.EJECT_MOTOR_SPEED);
    RobotContainer.motionInstance.setIntakePivotAngle(ConstMotion.DEPLOY_INTAKE_ANGLE);
    RobotContainer.rotorsInstance.setTransferMotorSpeed(ConstRotors.EJECT_MOTOR_SPEED)
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.rotorsInstance.setIntakeMotorSpeed(0);
    RobotContainer.motionInstance.setIntakePivotAngle(ConstMotion.RETRACT_INTAKE_ANGLE);
    RobotContainer.rotorsInstance.setTransferMotorSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
