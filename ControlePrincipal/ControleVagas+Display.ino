#include <LCD_I2C.h>

int Pinos_LedVermelho[5] = {3,4,5,6,7}; //tem que trocar quando for implementar
int Pinos_LedVerde[5] = {8,9,10,11,12}; //tem que trocar quando for implementar
int Pinos_LDR[5] = {A0,A1,A2,A3,A4}; // tem que trocar quando for implementar (A1, A2...); 



void SetupVagas(){


for(byte i = 0; i < 5; i++){
  pinMode(Pinos_LDR[i], INPUT_PULLUP);
}

for(byte i = 0; i < 5; i++){
  pinMode(Pinos_LedVerde[i], OUTPUT);
  pinMode(Pinos_LedVermelho[i], OUTPUT);
}




}

void LoopVagas(){
  
  for(byte i = 0; i < 5; i++){
    if(analogRead(Pinos_LDR[i]) > 450){
      digitalWrite(Pinos_LedVerde[i], LOW);
      digitalWrite(Pinos_LedVermelho[i], HIGH);
      
    }else {
      digitalWrite(Pinos_LedVerde[i], HIGH);
      digitalWrite(Pinos_LedVermelho[i], LOW);
      vagas = vagas + 1;
    }
  }
  

  

  
}