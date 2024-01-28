package main.java.zombieTsunami.view;

import java.awt.Graphics2D;

import main.java.zombieTsunami.api.Controller;
import main.java.zombieTsunami.view.api.VController;
import main.java.zombieTsunami.view.zombieView.api.DrawZombie;
import main.java.zombieTsunami.view.zombieView.impl.DrawZombieImpl;

public class VControllerImpl implements VController{
    
    private Controller control;

    @Override
    public void set(final Controller c){
        this.control=c;

        View.start(this, getScreenWC(), getScreenHC());
    }

    @Override
    public int getScreenWC(){
        return this.control.getScreenWidth();
    }

    @Override
    public int getScreenHC(){
        return this.control.getScreenHigh();
    }

    @Override
    public void updateZombieC() {
        this.control.updateZombie();
    }

    @Override
    public void drowMapC(final Graphics2D g2) {
        this.control.drowMap(g2);
    }

    @Override
    public int getFPSC() {
        return this.control.getFPS();
    }

    @Override
    public void drawZombieC(final Graphics2D g2) {
        DrawZombie zombie = new DrawZombieImpl();
        zombie.drawZombieV(g2,this);
    }
    @Override
    public int getMapX() {
        return this.control.getMapX();
    }

    @Override
    public int getMapY() {
        return this.control.getMapY();
    }

    @Override
    public int getSpeed() {
        return this.control.getSpeed();
    }

    @Override
    public int getNumX() {
        return this.control.getNumX();
    }
}
