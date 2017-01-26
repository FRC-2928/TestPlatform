package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2928.Robot;

public class ShooterCommand extends Command {

    public ShooterCommand() {
        super();
        requires(Robot.shooter);
    }

    @Override
    protected void execute() {
     double targetSpeed = Robot.oi.getDriveY() * 1500.0;
     Robot.shooter.setSetpoint(targetSpeed);
     SmartDashboard.putNumber("Talon Pid Output", Robot.shooter.pidOutput());
     SmartDashboard.putNumber("Talon PID Error", Robot.shooter.getMotor().getClosedLoopError());
     SmartDashboard.putNumber("Talon Speed", Robot.shooter.getMotor().getSpeed());

    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
