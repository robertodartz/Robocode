package Floowandereeze;

import robocode.*;

public class Floowandereeze extends AdvancedRobot {
    private boolean isMovingForward = true;
    private double lastEnemyEnergy = 100; // Inicializa com a energia máxima do inimigo

    public void run() {
        setAdjustRadarForGunTurn(true);
        setAdjustGunForRobotTurn(true);

        while (true) {
            moveRandom(); // Movimento aleatório após cada disparo
            execute();
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        double enemyBearing = e.getBearing();
        double gunTurnAngle = getHeading() + enemyBearing - getGunHeading();

        // Gira a arma na direção do inimigo
        turnGunRight(gunTurnAngle);

        // Verifica se há uma chance razoável de acertar o tiro antes de atirar
        if (Math.abs(gunTurnAngle) <= 10 && getEnergy() > 20) {
            fire(2); // Atira com potência 2 quando o inimigo está alinhado e você tem energia suficiente
            moveRandom(); // Movimento aleatório após cada disparo
        }

        // Estratégia de esquiva de balas
        double enemyEnergy = e.getEnergy();
        if (lastEnemyEnergy > enemyEnergy) {
            // O inimigo atirou, portanto, ajuste o movimento para evitar tiros
            moveRandom();
        }
        lastEnemyEnergy = enemyEnergy;
    }

    private void moveRandom() {
        // Movimento circular constante para cobrir toda a área
        setTurnRadarRight(360);

        // Altera a direção aleatoriamente
        if (Math.random() > 0.5) {
            isMovingForward = !isMovingForward;
        }

        // Acelera e desacelera suavemente para melhorar a precisão de movimento
        if (isMovingForward) {
            setAhead(100);
        } else {
            setBack(100);
        }
        setMaxVelocity(4); // Define a velocidade máxima
    }
}