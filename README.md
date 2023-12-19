# Robocode

Movimento:

O robô realiza um movimento circular constante para cobrir toda a área.
Altera a direção aleatoriamente (mudança de direção) para evitar padrões previsíveis.
Acelera e desacelera suavemente para melhorar a precisão de movimento.

Detecção de Robô:

Quando o evento onScannedRobot é acionado (indicando que um robô foi detectado), o robô gira a arma na direção do inimigo.

Disparo:

O robô atira quando a diferença angular entre a posição atual da arma e a posição do inimigo é menor ou igual a 10 graus.
O poder de fogo utilizado é 2 (definido por fire(2)).
O robô verifica se tem energia suficiente para atirar (mais de 20 de energia).

Esquiva de Balas:

O robô possui uma estratégia de esquiva de balas. Se a energia do inimigo diminuir desde a última verificação, o robô assume que o inimigo atirou e realiza um movimento aleatório para evitar os tiros.
