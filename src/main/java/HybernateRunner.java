import org.hibernate.Session;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Random;

public class HybernateRunner {

        public static void main(String[] args) {

            ElevService elevService = ElevService.getInstance();
            ClasaService clasaService = ClasaService.getInstance();

            Clasa clasa1 = clasaService.getClasa(1);

            System.out.println(clasa1);

            Clasa clasaNoua1 = new Clasa();
            clasaNoua1.numeClasa = "11C";
            clasaService.createClasa(clasaNoua1);

            Elevi elevNou = new Elevi();
            elevNou.numeElev = "Gica Petrescu";
            elevNou.setClasa(clasa1);
            elevService.createElev(elevNou);
            System.out.println(elevNou);

            HibernateUtil.shutdown();
        }

        public static Materii getMaterii(Integer id) {
            try {
                Session session = HibernateUtil.getSessionFactory().openSession();
                Materii materii = session.find(Materii.class, id);
                return materii;
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }

        public static Profesori getProfesori(Integer id) {

            try {
                Session session = HibernateUtil.getSessionFactory().openSession();
                Profesori profi = session.find(Profesori.class, id);
                return profi;
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }

}
