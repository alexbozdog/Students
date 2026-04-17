import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ro.ulbs.proiectaresoftware.students.AplicatieCuBursa;
import ro.ulbs.proiectaresoftware.students.StudentBursieri;

import java.util.List;

public class AplicatieCuBursaTest {

    @Test
    public void testSorteaza() {
        AplicatieCuBursa app = new AplicatieCuBursa();
        List<StudentBursieri> lista = app.genereaza();

        app.sorteaza(lista);

        assertEquals("ISM141/1", lista.get(0).getFormatieDeStudiu());
        assertEquals("Mihalcea", lista.get(0).getNume());

        boolean gasitBursaMica = false;
        for(int i = 0; i < lista.size() - 1; i++) {
            StudentBursieri curent = lista.get(i);
            StudentBursieri urmator = lista.get(i+1);


            if(curent.getNume().equals(urmator.getNume()) && curent.getNota() == urmator.getNota()) {
                assertTrue(curent.getCuantumBursa() <= urmator.getCuantumBursa(),
                        "Sortarea după cuantum bursă a eșuat pentru valori egale de nume/notă");
            }
        }
    }
}