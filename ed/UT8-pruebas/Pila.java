/**
 * Implementación de pila simple.
 * No utilizable en la vida real.
 */
class Pila{
        private static String[] pila = new String[50];
        private static int pico = -1; // -1 vacia

        public Pila( String s ){
            this.pila = s.split(" ");
            this.pico = this.pila.length-1;
        }

        public static String pop() {
            String s;
            if (pico >= 0) {
                s = pila[pico];
                pila[pico--] = null;
            } else {
                s = null;
            }
            return s;
        }
        public static void push( String s ){
            if( pico < 0 ){
                pila[0] = s;
                pico = 0;
            } else {
                pila[++pico] = s;
            }
        }

        public static String toText(){
            StringBuffer sb = new StringBuffer("{");
            for(String s: pila){
                sb.append(s + " ");
            }
            sb.append("}");
            return sb.toString();
        } //toString()
    } // class Pila
