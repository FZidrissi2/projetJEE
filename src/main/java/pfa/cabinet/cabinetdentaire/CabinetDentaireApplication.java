package pfa.cabinet.cabinetdentaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pfa.cabinet.cabinetdentaire.entities.Appointment;
import pfa.cabinet.cabinetdentaire.entities.Patient;
import pfa.cabinet.cabinetdentaire.entities.Secretary;
import pfa.cabinet.cabinetdentaire.repository.AppointmentRepository;
import pfa.cabinet.cabinetdentaire.repository.PatientRepository;
import pfa.cabinet.cabinetdentaire.repository.SecretaryRepository;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class CabinetDentaireApplication implements CommandLineRunner  {


	private final AppointmentRepository appointmentRepository;
	private final PatientRepository patientRepository;
	private final SecretaryRepository secretaryRepository;

	@Autowired
	public CabinetDentaireApplication(SecretaryRepository secretaryRepository,AppointmentRepository appointmentRepository,PatientRepository patientRepository) {
		this.appointmentRepository = appointmentRepository;
		this.patientRepository=patientRepository;
		this.secretaryRepository=secretaryRepository;

	}

	public static void main(String[] args) {
		SpringApplication.run(CabinetDentaireApplication.class, args);
	}

	@Override
	public void run(String... args) {


		Patient p1 = patientRepository.save(new Patient(null,"photo","fatima zahra","el idrissi",LocalDate.now(),"rabat","GB240017","0701283773",LocalDate.now(),"rabat","Male",null));
		Patient p2 = patientRepository.save(new Patient(null,"photo","kawtar","ezzouhri",LocalDate.now(),"rabat","GB240017","0701283773",LocalDate.now(),"rabat","Male",null));
		Patient p3 = patientRepository.save(new Patient(null,"photo","othmane","el idrissi",LocalDate.now(),"rabat","GB240017","0701283773",LocalDate.now(),"rabat","Female",null));
		Patient p4 = patientRepository.save(new Patient(null,"photo","anis","benyoub",LocalDate.now(),"rabat","GB240017","0701283773",LocalDate.now(),"rabat","Male",null));
		Patient p5 = patientRepository.save(new Patient(null,"photo","salma","ezzouhri",LocalDate.now(),"rabat","GB240017","0701283773",LocalDate.now(),"rabat","Male",null));

		appointmentRepository.save(new Appointment(null,  LocalDate.now(), LocalTime.now(),LocalTime.now(),250,p1));
		appointmentRepository.save(new Appointment(null,  LocalDate.now(), LocalTime.now(),LocalTime.now(),250,p1));
		appointmentRepository.save(new Appointment(null, LocalDate.now(), LocalTime.now(),LocalTime.now(),250,p5));
		appointmentRepository.save(new Appointment(null, LocalDate.now(), LocalTime.now(),LocalTime.now(),50,p3));
		appointmentRepository.save(new Appointment(null, LocalDate.now(), LocalTime.now(),LocalTime.now(),250,p2));
		appointmentRepository.save(new Appointment(null, LocalDate.now(), LocalTime.now(),LocalTime.now(),250,p4));
		appointmentRepository.save(new Appointment(null, LocalDate.now(), LocalTime.now(),LocalTime.now(),250,p5));
		appointmentRepository.save(new Appointment(null, LocalDate.now(), LocalTime.now(),LocalTime.now(),250,p2));
		appointmentRepository.save(new Appointment(null, LocalDate.now(), LocalTime.now(),LocalTime.now(),250,p4));
		appointmentRepository.save(new Appointment(null, LocalDate.now(), LocalTime.now(),LocalTime.now(),250,p4));
		appointmentRepository.save(new Appointment(null, LocalDate.now(), LocalTime.now(),LocalTime.now(),250,p3));

		secretaryRepository.save(new Secretary(null,"khawla","imgharen","Female", LocalDate.now(),"0701283773","sale","hay essalam",4000.4,"secretary@email.com","toto","secretaire","GB240017"));
		secretaryRepository.save(new Secretary(null,"khalid","lahmaini","Male", LocalDate.now(),"0760051235","rabat","agdal",6000.0,"secretary@email.com","1234","secretaire","AY6164"));

	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
