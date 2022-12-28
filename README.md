# java-polynome
Implanter une classe Polynome qui permettra de décrire un polynôme de x tel que: 5.5x^9 + 9x^7 - x - 10 (eq. 1) . Le symbole « ^» définie un opérateur d’exponentiation. Il faudra stocker le polynôme sous la forme d'une liste chaînée des termes. Chaque terme représente une paire : un coefficient et une puissance de x. 
Vous devez concevoir le support des opérations suivantes :
Additionner 2 polynômes, par exemple : p1(x)= 10x^2 + 5.2x + 20 p2(x) = 75x^4 + 5.2x^2 + 3x p1(x) + p2(x) = 75x^4 + 15.2x^2 + 8.2x + 20 Multiplier un polynôme par une constante, par exemple : p(x) = 10x^2 + 5.2x + 20 -2 * p(x) = -20x^2 - 10.4x - 40 Multiplier 2 polynômes ensemble, par exemple : p1(x) = 10x^2 + 20 p2(x) = 75x^4 + 5.2x^2 + 3x p1(x) * p2(x) = (10x^2 + 20) * (75x^4 + 5.2x^2 + 3x) = = 10x^2 * (75x^4 + 5.2x^2 + 3x) + 20 * (75x^4 + 5.2x^2 + 3x) = = 750x^6 + 1552x^4 + 30x^3 + 104x^2 + 60x Calculer la dérivée d'un polynôme : p(x) = ax^n + bx^(n - 1) + ... + jx^1 + kx^0 p'(x) = (a * n)x^(n - 1) + (b * (n - 1))x^(n - 2) + ... + jx^0