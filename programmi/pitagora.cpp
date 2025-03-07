#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <iostream>
#include <string>
#define START_FREQ 440

using namespace std;

int main(int argc, char const *argv[])
{
    int numero_note = 12;
    string note[numero_note] = {
        "do",
        "do#",
        "re",
        "re#",
        "mi",
        "fa",
        "fa#",
        "sol",
        "sol#",
        "la",
        "la#",
        "si"
    };
    
    int freq[numero_note]; for (int i = 0 ; i < numero_note; i++) freq[i] = 0;

    double fr = START_FREQ;
    double fr2 = fr * 2;

    int nota_corrispondente = 0; 
    for (int i = 0; i < numero_note; i++) {
        double i_freq = fr * pow((1.5), i);
        while (i_freq > fr2)
        {
            i_freq /= 2; 
        }
        
        freq[nota_corrispondente] = i_freq;
        nota_corrispondente += 8;
        nota_corrispondente %= 12;
    }

    for (int i = 0; i < numero_note; i++) {
        cout << note[i] << ": " << freq[i] << endl;
    }
    
    return 0;
}
