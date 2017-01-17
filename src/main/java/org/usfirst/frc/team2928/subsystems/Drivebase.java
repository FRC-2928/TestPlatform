package org.usfirst.frc.team2928.subsystems;

import org.usfirst.frc.team2928.commands.JoystickDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The drive system on the test platform consists of one motor.
 */
public class Drivebase extends Subsystem {

    private static final int MOTOR_DEVICE_NUMBER = 7;

    private final CANTalon motor;

    public Drivebase() {
        super();
        motor = new CANTalon(MOTOR_DEVICE_NUMBER);
    }

    public void drive(final double input) {
        motor.set(input);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new JoystickDrive());
    }
}
