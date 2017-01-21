package org.usfirst.frc.team2928.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDInterface;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2928.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ConstantDrive extends PIDCommand {

    private final double output;

    public ConstantDrive(final double output) {
        super(.0001,0,0);
        requires(Robot.drivebase);

        getPIDController().setAbsoluteTolerance(100);
        getPIDController().setOutputRange(0,.7);

        this.output = output;
    }

    @Override
    protected void usePIDOutput(double output){
       // output =.2;
        Robot.drivebase.drive(output);
    }

    @Override
    protected double returnPIDInput(){
        return Robot.drivebase.getEncVelocity();
    }

    @Override
    protected void initialize() {
        //Robot.drivebase.drive(output);

        setSetpoint(2000);
    }

    @Override
    protected  void execute() {
        int counter = 0;
        if (counter % 10 == 0) {
            SmartDashboard.putNumber("Enc Velocity ", Robot.drivebase.getEncVelocity());

            counter++;
        }
        else {
            counter++;
        }
        }

    @Override
    protected boolean isFinished() {
        return this.getPIDController().onTarget();
    }
}
