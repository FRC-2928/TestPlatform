package org.usfirst.frc.team2928;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import org.usfirst.frc.team2928.commands.ConstantDrive;
import org.usfirst.frc.team2928.commands.JoystickDrive;
import org.usfirst.frc.team2928.commands.ShooterCommand;
import org.usfirst.frc.team2928.subsystems.Drivebase;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team2928.subsystems.Shooter;

/**
 * Robot for the test platform.
 */
public class Robot extends IterativeRobot {

    public static Drivebase drivebase;
    public static OperatorInterface oi;
    public static Shooter shooter;

    @Override
    public void robotInit() {
        oi = new OperatorInterface();
        drivebase = new Drivebase();
        shooter = new Shooter();
    }

    @Override
    public void teleopInit() {
        Scheduler.getInstance().removeAll();
        new JoystickDrive().start();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        LiveWindow.run();
    }

    @Override
    public void autonomousInit() {
        new ConstantDrive(2000).start();
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        LiveWindow.run();
    }
}
