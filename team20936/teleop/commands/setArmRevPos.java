package org.firstinspires.ftc.teamcode.team20936.teleop.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.team20936.teleop.subsystems.revSubsystem;

public class setArmRevPos extends CommandBase {

    revSubsystem m_revSubsystem;
    int target;

    public setArmRevPos (revSubsystem subsystem, int target) {
        m_revSubsystem = subsystem;
        this.target = target;
        addRequirements(m_revSubsystem);
    }

    @Override
    public void initialize() { m_revSubsystem.setArmRevPos(target); }

    @Override
    public boolean isFinished() { return true; }

}
