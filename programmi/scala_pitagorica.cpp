#include <iostream>
#include <cmath>
using namespace std;

void printer(char nota, double frequenza) {
    cout << nota << ": " << frequenza << " Hz" << endl;
}

int main() {
    double tre_mezzi = (double) 3.0 / 2.0;
    double frequenza_partenza = 349.23;
    char nota = 'F';
    printer(nota, frequenza_partenza);

    double frequenza = frequenza_partenza;
    for (int i = 0; i < 6; i++) {
        frequenza *= tre_mezzi;
        if (frequenza > 2 * frequenza_partenza) {
            frequenza /= 2;
        }
        nota++;
        if (nota > 'G') {
            nota = 'A';
        }

        printer(nota, frequenza);
    }
}