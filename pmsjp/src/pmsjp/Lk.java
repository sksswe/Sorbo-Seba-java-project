package pmsjp;
import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    private String pid, pname, disease, hospitalName, doctorName, status;
    private int age;

    public Patient(String pid, String pname, String disease, String hospitalName, String doctorName, String status, int age) {
        this.pid = pid;
        this.pname = pname;
        this.disease = disease;
        this.hospitalName = hospitalName;
        this.doctorName = doctorName;
        this.status = status;
        this.age = age;
    }

    // Getter methods
    public String getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public String getDisease() {
        return disease;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getStatus() {
        return status;
    }

    public int getAge() {
        return age;
    }

    // Setter methods
    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Admin {
    ArrayList<Patient> patients = new ArrayList<>();

    // Method to add a new patient
    public void addPatient() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter patient NID: ");
        String pid = input.nextLine();
        System.out.print("Enter patient name: ");
        String pname = input.nextLine();
        System.out.print("Enter disease: ");
        String disease = input.nextLine();
        System.out.print("Enter hospital name: ");
        String hospitalName = input.nextLine();
        System.out.print("Enter doctor name: ");
        String doctorName = input.nextLine();
        System.out.print("Enter status: ");
        String status = input.nextLine();
        System.out.print("Enter age: ");
        int age = input.nextInt();

        Patient newPatient = new Patient(pid, pname, disease, hospitalName, doctorName, status, age);
        patients.add(newPatient);
        System.out.println("Patient added successfully!");
    }

    // Method to delete a patient based on patient id
    public void deletePatient(String pid) {
        for (Patient patient : patients) {
            if (patient.getPid().equals(pid)) {
                patients.remove(patient);
                System.out.println("Patient deleted successfully!");
                return;
            }
        }
        System.out.println("Patient with NID " + pid + " not found.");
    }

    // Method to display all patients
    public void displayAllPatients() {
        for (Patient patient : patients) {
            System.out.println(patient.getPid() + "\t" + patient.getPname() + "\t" + patient.getAge() + "\t"
                    + patient.getDisease() + "\t" + patient.getStatus() + "\t" + patient.getHospitalName() + "\t" + patient.getDoctorName());
        }
    }

    // Method to search and display information for a specific patient based on patient id
    public void searchPatient(String pid) {
        for (Patient patient : patients) {
            if (patient.getPid().equals(pid)) {
                System.out.println(patient.getPid() + "\t" + patient.getPname() + "\t" + patient.getAge() + "\t"
                        + patient.getDisease() + "\t" + patient.getStatus() + "\t" + patient.getHospitalName() + "\t" + patient.getDoctorName());
                return;
            }
        }
        System.out.println("Patient with id " + pid + " not found.");
    }

    // Method to update patient information based on patient id
    public void updatePatient(String pid) {
        for (Patient patient : patients) {
            if (patient.getPid().equals(pid)) {
                Scanner input = new Scanner(System.in);
                System.out.println("Enter new information for patient with NID " + pid + ":");
                System.out.print("Enter new patient name: ");
                String newName = input.nextLine();
                System.out.print("Enter new disease: ");
                String newDisease = input.nextLine();
                System.out.print("Enter new hospital name: ");
                String newHospitalName = input.nextLine();
                System.out.print("Enter new doctor name: ");
                String newDoctorName = input.nextLine();
                System.out.print("Enter new status: ");
                String newStatus = input.nextLine();
                System.out.print("Enter new age: ");
                int newAge = input.nextInt();

                // Update patient information
                patient.setPname(newName);
                patient.setDisease(newDisease);
                patient.setHospitalName(newHospitalName);
                patient.setDoctorName(newDoctorName);
                patient.setStatus(newStatus);
                patient.setAge(newAge);

                System.out.println("Patient information updated successfully!");
                return;
            }
        }
        System.out.println("Patient with NID " + pid + " not found.");
    }

	public boolean adminLogin(String adminUsername, String adminPassword) {
		 return adminUsername.equals("admin") && adminPassword.equals("adminpass");
	}
}

class Doctor {
    private ArrayList<Patient> patients;

    // Constructor
    public Doctor(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    // Method to display information for a specific patient based on patient id
    public void viewPatientInfo(String pid) {
        for (Patient patient : patients) {
            if (patient.getPid().equals(pid)) {
                System.out.println(patient.getPid() + "\t" + patient.getPname() + "\t" + patient.getAge() + "\t"
                        + patient.getDisease() + "\t" + patient.getStatus() + "\t" + patient.getHospitalName() + "\t" + patient.getDoctorName());
                return;
            }
        }
        System.out.println("Patient with NID " + pid + " not found.");
    }

    // Method to update patient information based on patient id
    public void updatePatient(String pid) {
        for (Patient patient : patients) {
            if (patient.getPid().equals(pid)) {
                Scanner input = new Scanner(System.in);
                System.out.println("Enter new information for patient with NID " + pid + ":");
                System.out.print("Enter new disease: ");
                String newDisease = input.nextLine();
                System.out.print("Enter new hospital name: ");
                String newHospitalName = input.nextLine();
                System.out.print("Enter new doctor name: ");
                String newDoctorName = input.nextLine();
                System.out.print("Enter new status: ");
                String newStatus = input.nextLine();
                System.out.print("Enter new age: ");
                int newAge = input.nextInt();

                // Update patient information
                patient.setDisease(newDisease);
                patient.setHospitalName(newHospitalName);
                patient.setDoctorName(newDoctorName);
                patient.setStatus(newStatus);
                patient.setAge(newAge);

                System.out.println("Patient information updated successfully!");
                return;
            }
        }
        System.out.println("Patient with NID " + pid + " not found.");
    }

    // Method for doctor login
    public boolean doctorLogin(String username, String password) {
        return username.equals("doctor") && password.equals("doctorpass");
    }
}

class PatientSystem {
    public static void main(String[] args) {
    	
    	
    	
    	System.out.println("\n--------------------------------------------");
        System.out.println("        *** Welcome to Sorbo Seba ***");
        System.out.println("--------------------------------------------");
        
        
    	
        Admin admin = new Admin();
        Doctor doctor = new Doctor(admin.patients);

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Admin");
            System.out.println("2. Doctor");
            System.out.println("3. Patient");
            System.out.println("4. Exit");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    adminOptions(admin);
                    break;
                case 2:
                    doctorOptions(doctor);
                    break;
                case 3:
                    patientOptions(admin, doctor);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    private static void adminOptions(Admin admin) {
    	
    	System.out.println("-------------------------------------------");
        System.out.println("          **ADMIN SECTION**");
        System.out.println("-------------------------------------------");
    	
    	
        Scanner input = new Scanner(System.in);

        System.out.print("Enter admin username: ");
        String adminUsername = input.next();
        System.out.print("Enter admin password: ");
        String adminPassword = input.next();

        if (admin.adminLogin(adminUsername, adminPassword)) {
            while (true) {
            	
            	System.out.println("-------------------------------------------");
                System.out.println("          **ADMIN SECTION**");
                System.out.println("-------------------------------------------");
            	
            	
                System.out.println("Admin Options:");
                System.out.println("1. Add Patient");
                System.out.println("2. Delete Patient");
                System.out.println("3. Display All Patients");
                System.out.println("4. Search Patient");
                System.out.println("5. Update Patient");
                System.out.println("6. Back to Main Menu");

                int adminChoice = input.nextInt();

                switch (adminChoice) {
                    case 1:
                    	
                    	System.out.println("-------------------------------------------");
                        System.out.println("          **ADMIN SECTION**");
                        System.out.println("-------------------------------------------");
                    	
                        admin.addPatient();
                        break;
                    case 2:
                    	
                    	System.out.println("-------------------------------------------");
                        System.out.println("          **ADMIN SECTION**");
                        System.out.println("-------------------------------------------");
                    	
                        System.out.print("Enter patient NID to delete: ");
                        String deletePid = input.next();
                        admin.deletePatient(deletePid);
                        break;
                    case 3:
                    	
                    	System.out.println("-------------------------------------------");
                        System.out.println("          **ADMIN SECTION**");
                        System.out.println("-------------------------------------------");
                    	
                        admin.displayAllPatients();
                        break;
                    case 4:
                    	
                    	System.out.println("-------------------------------------------");
                        System.out.println("          **ADMIN SECTION**");
                        System.out.println("-------------------------------------------");
                        
                        System.out.print("Enter patient NID to search: ");
                        String searchPid = input.next();
                        admin.searchPatient(searchPid);
                        break;
                    case 5:
                    	
                    	System.out.println("-------------------------------------------");
                        System.out.println("          **ADMIN SECTION**");
                        System.out.println("-------------------------------------------");
                        
                        System.out.print("Enter patient NID to update: ");
                        String updatePid = input.next();
                        admin.updatePatient(updatePid);
                        break;
                    case 6:
                    	
                    	System.out.println("\n--------------------------------------------");
                        System.out.println("        *** Welcome to Sorbo Seba ***");
                        System.out.println("--------------------------------------------");
                    	
                        return;
                    default:
                    	
                    	System.out.println("-------------------------------------------");
                        System.out.println("          **ADMIN SECTION**");
                        System.out.println("-------------------------------------------");
                    	
                        System.out.println("Invalid choice. Please choose again.");
                }
            }
        } else {
        	
        	System.out.println("-------------------------------------------");
            System.out.println("          **ADMIN SECTION**");
            System.out.println("-------------------------------------------");
        	
            System.out.println("Invalid admin credentials. Admin login failed.");
        }
    }

    private static void doctorOptions(Doctor doctor) {
    	
    	System.out.println("-------------------------------------------");
        System.out.println("          **DOCTOR SECTION**");
        System.out.println("-------------------------------------------");
    	
        Scanner input = new Scanner(System.in);

        System.out.print("Enter doctor username: ");
        String doctorUsername = input.next();
        System.out.print("Enter doctor password: ");
        String doctorPassword = input.next();

        if (doctor.doctorLogin(doctorUsername, doctorPassword)) {
            while (true) {
            	
            	System.out.println("-------------------------------------------");
                System.out.println("          **DOCTOR SECTION**");
                System.out.println("-------------------------------------------");
            	
                System.out.println("Doctor Options:");
                System.out.println("1. View Patient Info");
                System.out.println("2. Update Patient Info");
                System.out.println("3. Back to Main Menu");

                int doctorChoice = input.nextInt();

                switch (doctorChoice) {
                    case 1:
                    	
                    	System.out.println("-------------------------------------------");
                        System.out.println("          **DOCTOR SECTION**");
                        System.out.println("-------------------------------------------");
                    	
                        System.out.print("Enter patient NID to view information: ");
                        String viewPid = input.next();
                        doctor.viewPatientInfo(viewPid);
                        break;
                    case 2:
                    	
                    	System.out.println("-------------------------------------------");
                        System.out.println("          **DOCTOR SECTION**");
                        System.out.println("-------------------------------------------");
                    	
                        System.out.print("Enter patient NID to update information: ");
                        String updatePid = input.next();
                        doctor.updatePatient(updatePid);
                        break;
                    case 3:
                    	
                    	System.out.println("\n--------------------------------------------");
                        System.out.println("        *** Welcome to Sorbo Seba ***");
                        System.out.println("--------------------------------------------");
                    	
                        return;
                    default:
                    	
                    	System.out.println("-------------------------------------------");
                        System.out.println("          **DOCTOR SECTION**");
                        System.out.println("-------------------------------------------");
                    	
                        System.out.println("Invalid choice. Please choose again.");
                }
            }
        } else {
        	
        	System.out.println("-------------------------------------------");
            System.out.println("          **DOCTOR SECTION**");
            System.out.println("-------------------------------------------");
        	
            System.out.println("Invalid doctor credentials. Doctor login failed.");
        }
    }

    private static void patientOptions(Admin admin, Doctor doctor) {
    	
    	
        Scanner input = new Scanner(System.in);

        while (true) {
        	
        	System.out.println("-------------------------------------------");
            System.out.println("       **USER/PATIENT SECTION**");
            System.out.println("-------------------------------------------");
        	
            System.out.println("User/Patient Options:");
            System.out.println("1. View Patient Info");
            System.out.println("2. Back to Main Menu");

            int patientChoice = input.nextInt();

            switch (patientChoice) {
                case 1:
                	
                	System.out.println("-------------------------------------------");
                    System.out.println("       **USER/PATIENT SECTION**");
                    System.out.println("-------------------------------------------"); 
                	
                    System.out.print("Enter patient id to view information: ");
                    String viewPid = input.next();
                    if (admin != null) {
                        admin.searchPatient(viewPid);
                    } else {
                        doctor.viewPatientInfo(viewPid);
                    }
                    break;
                case 2:
                	
                	System.out.println("\n--------------------------------------------");
                    System.out.println("        *** Welcome to Sorbo Seba ***");
                    System.out.println("--------------------------------------------");
                	
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
