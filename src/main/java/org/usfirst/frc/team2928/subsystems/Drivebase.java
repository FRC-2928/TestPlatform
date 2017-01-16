package org.usfirst.frc.team2928.subsystems;

import org.usfirst.frc.team2928.commands.JoystickDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The drive system on the test platform consists of one motor.
 */
public class Drivebase extends Subsystem {

    private final CANTalon motor;

    public Drivebase() {
        super();
        // TODO: determine device number for the motor
        motor = new CANTalon(0);
    }

    public void drive(final double input) {
        motor.set(input);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new JoystickDrive());
    }
}
