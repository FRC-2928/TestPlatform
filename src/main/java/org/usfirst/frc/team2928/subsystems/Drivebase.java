package org.usfirst.frc.team2928.subsystems;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2928.Robot;
import org.usfirst.frc.team2928.commands.JoystickDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The drive system on the test platform consists of one motor.
 */
public class Drivebase extends Subsystem {

    private static final int MOTOR_DEVICE_NUMBER = 14;
    private static final int OTHER_MOTOR_DEVICE_NUMBER= 15;

    private final CANTalon motor;
    //private final CANTalon motor2;
    private final PIDController speedController;

    public Drivebase() {
        super();
        motor = new CANTalon(MOTOR_DEVICE_NUMBER);
        CANTalon motor2 = new CANTalon(OTHER_MOTOR_DEVICE_NUMBER);
        motor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
       // motor.changeControlMode(CANTalon.TalonControlMode.Speed);
        motor2.changeControlMode(CANTalon.TalonControlMode.Follower);
        motor2.set(MOTOR_DEVICE_NUMBER);

        PIDSource m_source = new PIDSource() {
            public void setPIDSourceType(PIDSourceType pidSource) {
            }

            public PIDSourceType getPIDSourceType() {
                return PIDSourceType.kRate;
            }

            public double pidGet() {
                SmartDashboard.putNumber("Enc Velocity ", motor.getEncVelocity());
                return motor.getEncVelocity();
            }
        };

        speedController = new PIDController(.00001,0.0, 0.0, m_source, this::setMotorOutput);
        speedController.setAbsoluteTolerance(100);
        speedController.setOutputRange(0,.7);
        speedController.setSetpoint(0.0);
        speedController.enable();
    }

    private void setMotorOutput(double output) {
        motor.set(-output);
    }

    public void drive(final double input) {
        speedController.setSetpoint(input);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new JoystickDrive());
    }
}
