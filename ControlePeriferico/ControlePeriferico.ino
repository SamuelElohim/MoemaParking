#include <Arduino_GFX_Library.h>
#include "Arduino_DataBus.h"
#include "Arduino_GFX.h"
#define GFX_BL 21

Arduino_DataBus *bus = new Arduino_SWSPI(5 /* DC */, 2 /* CS */, 19 /* SCK */, 18 /* SDA */, -1 /* MISO */);
Arduino_GFX *gfx = new Arduino_SSD1283A(bus, 4 /* RST */, 0 /* rotation */);

extern void setup1();
extern void setup2();
extern void loop1();
extern void loop2();

void setup() {
  setup1();
  setup2();
}

void loop() {
  loop1();
  loop2();

}
