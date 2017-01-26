package org.usfirst.frc.team2928.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2928.Robot;

public class Shooter extends Subsystem {
    private static final int FIRST_SHOOTER_PORT = 7;
    private static final int SECOND_SHOOTER_PORT = 7;
    private final CANTalon motor;
    private double joystickYValue = Robot.oi.getDriveY();
    private double motorOutput;
    public Shooter (){
        this.motor= new CANTalon(FIRST_SHOOTER_PORT);
      //  CANTalon slave = new CANTalon(SECOND_SHOOTER_PORT );
        motor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        motor.changeControlMode(CANTalon.TalonControlMode.Speed);
    //    slave.changeControlMode(CANTalon.TalonControlMode.Follower);
        //motor.configNominalOutputVoltage(0.0f,-0.0f);
        motor.configPeakOutputVoltage(+12.0f,-12.0f);
        //motor.setProfile(0);
        motor.setF(0);
        motor.setP(.00001);
        motor.setI(0);
        motor.setD(0);
        //this.motorOutput = motor.getOutputVoltage()/motor.getBusVoltage();
    }


    public void setSetpoint(double setpoint){
        motor.set(setpoint);
        SmartDashboard.putNumber("Setpoint", setpoint);
    }
    public double pidOutput(){
        return motor.getEncVelocity();
    }
    public CANTalon getMotor(){return  motor;}
    @Override
    protected void initDefaultCommand() {

    }

}
