package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.intakeConstants;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends Command {
    private final Joystick joystick; 
    private final IntakeSubsystem m_IntakeSubsystem; 

    public IntakeCommand(IntakeSubsystem IntakeSubsystem, Joystick controller) {
        joystick = controller;
        m_IntakeSubsystem = IntakeSubsystem;  
        addRequirements(m_IntakeSubsystem);
    } 
    @Override
    public void execute() { 
    //If the button specified in the constants is pressed, begin the intake motor.  
        if (joystick.getRawButtonPressed(intakeConstants.intakeButton)) {
            m_IntakeSubsystem.intake();  
        }  
        if (joystick.getRawButtonReleased(intakeConstants.intakeButton)) {
            m_IntakeSubsystem.stop();
        }

    } 
    @Override
    public void end(boolean interrupted) {
        m_IntakeSubsystem.stop();
    }
    @Override
    public boolean isFinished() {
        return false;
    }
}
