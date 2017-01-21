package org.usfirst.frc.team2928;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import org.usfirst.frc.team2928.commands.ConstantDrive;
import org.usfirst.frc.team2928.subsystems.Drivebase;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * Robot for the test platform.
 */
public class Robot extends IterativeRobot {

    public static Drivebase drivebase;
    public static OperatorInterface oi;
    public LiveWindow lv =new LiveWindow();

    @Override
    public void robotInit() {
        oi = new OperatorInterface();
        drivebase = new Drivebase();
        LiveWindow.addActuator("Drivebase", "drive", drivebase.getTalon());

    }

    @Override
    public void teleopInit() {
        Scheduler.getInstance().removeAll();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        lv.run();
    }

    @Override
    public void autonomousInit() {
        new ConstantDrive(-0.8).start();
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        lv.run();
    }
}
