package org.usfirst.frc.team2928.subsystems;

import org.usfirst.frc.team2928.commands.JoystickDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The drive system on the test platform consists of one motor.
 */
public class Drivebase extends Subsystem {

    private static final int MOTOR_DEVICE_NUMBER = 7;
    private static final int OTHER_MOTOR_DEVICE_NUMBER= 5;

    private final CANTalon motor;
    //private final CANTalon motor2;

    public Drivebase() {
        super();
        motor = new CANTalon(MOTOR_DEVICE_NUMBER);
        //motor2 = new CANTalon(OTHER_MOTOR_DEVICE_NUMBER);
        motor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        motor.changeControlMode(CANTalon.TalonControlMode.Speed);
        //motor2.changeControlMode(CANTalon.TalonControlMode.Follower);
        //motor2.set(MOTOR_DEVICE_NUMBER);
        motor.set(0);
    }

    public void drive(final double input) {
        motor.set(input);
    }

    public double getEncVelocity() {
        return this.motor.getEncVelocity();
    }

    public CANTalon getTalon(){
        return motor;
    }


    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new JoystickDrive());
    }
}
