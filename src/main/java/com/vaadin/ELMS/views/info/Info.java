package com.vaadin.ELMS.views.info;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "info", layout = com.vaadin.ELMS.ui.MainLayout.class)
@PageTitle("Information | Employee Leave Management System")
public class Info extends VerticalLayout{

    ComboBox<String> combo = new ComboBox<>();
    TextArea info = new TextArea();
    public Info(){
        
        setSizeFull();
        setPadding(true);
        setHorizontalComponentAlignment(Alignment.STRETCH);
        setAlignItems(Alignment.STRETCH);
       
        combo.setItems("General","Casual Leave", "Earned Leave", "Half Pay Leave", "Leave Not Due", "Maternity Leave","Adoption Leave", "Work Related Injury or Illness Leave", "On Duty Leave", "Special Case Leave","Vacation", "Commuted Leave", "Extra Ordinary Leave", "Paternity Leave", "Child Care Leave");
        combo.setLabel("Info about : ");
        combo.setRequired(true);
        combo.setRequiredIndicatorVisible(true);
        combo.addValueChangeListener(click -> info.setValue(setInfo()));

        info.setReadOnly(true);

        add(new H2("Information"),combo,info);
        
    }

    private String setInfo() {
        switch(combo.getValue()) {
            case "General":
                return "";
            case "Casual Leave":
                return "Casual Leave is not a recognized form of leave and is not subject to any rules made by the Government of India." +
                "\n" + "  An employee on casual leave is not treated as absent from duty and his pay is not intermitted." + 
                "\n" + "  1.  Entitlement 8 days in total (per Calendar Year – Jan to Dec)" + 
                "\n" + "  2.  Employees joining during the year may avail proportionately or the full period at the discretion of the competent authority." +
                "\n" + "  3.  Casual Leave can be combined with Special Casual Leave/ Vacation/ any holidays, but not with any other kind of leave." +
                "\n" + "  4.  Holidays falling during a period of casual leave are not counted as part of CL." +
                "\n" + "  5.  Saturday/ Sunday/ public holidays/ weekly offs can be prefixed or suffixed to CL." +
                "\n" + "  6.  Casual Leave can be taken on tour, but no daily allowance will be admissible for the period." +
                "\n" + "  7.  Casual Leave can be taken for half-day also." +
                "\n" + "  8.  Casual Leave should not normally be granted for more than 5 days at any one time." +
                "\n" + "  9.  LTC can be availed during casual leave." +
                "\n" + "  10. Half a day’s casual leave should be debited to the CL account of an employee for each late attendance but late attendance up to an hour, or not more than two occasions in a month. It may be condoned by the competent authority, if he is satisfied that it is due to unavoidable reasons." +
                "\n" + "  11. Casual Leave can not be combined with joining time." +
                "\n" + "  12. Casual Leave and Earned Leave cannot be combined.";
            case "Earned Leave":
                return "All the employees of the Institute are eligible for Earned Leave." +
                "\n" + "  1.  The earned leave admissible to an employee of the Institute shall be 30 days in a calendar year." +
                "\n" + "  2.  Earned Leave is credited to an employee in advance at a uniform rate of 15 days on the 1st January and 1st July every year." +
                "\n" + "  3.  Earned Leave can be accumulated up to 300 days, including the number of days for which encashment has been allowed along with LTC – Rule 26 (1)." +
                "\n" + "  4.  The credit for the half-year in which an employee is appointed will be at the rate of 2 ½ days for each completed calendar month of service." +
                "\n" + "  5.  Earned Leave credit for the half-year in which the employee retires/ resigns/ removed/ dismissed or dies in middle of calender year, the earned leavecreditted should be reduced at the rate of 1/10th of any extraordinary leave taken in that half year and leave account regularised. While affording credit fraction shall be rounded off to the nearest day." +
                "\n" + "  6.  While limiting the maximum of 300 days, where the balance at credit is 286-300 days, further advance credit of 15 days on 1st January/ 1st July will be kept separately and set-off against the EL availed of during that half-year ending 30th June/ 31st December. However, if the leave availed is less than 15 days, the reminder will be credited to the leave account subject to the ceiling of 300 days at the close of that half-year." +
                "\n" + "  7.  Earned Leave does not exceed 300 days. Such procedure may be restored to in cases where Earned Leave at the credit of the employee on the last day of December or June is 300." +
                "\n" + "  8.  The credit for the half-year in which a Government servant is appointed will be afforded at the rate of 2 ½ days for each completed calendar month in that halfyear up to the date of retirement." +
                "\n" + "  9.  The maximum amount of earned leave that can be granted to an employee at a time shall be 180 days; however, earned Leave my be taken at a time up to 300 days as leave preparatory to retirement." +
                "\n" + "  10. Earned Leave up to 300 days at a time may be granted to Group A and Group B employees, if at least the quantum of leave in excess of 180 days is spent outside India, Nepal, Bangladesh, Bhutan, Srilanka and Pakistan." +
                "\n" + "  11. While availing LTC, encashment of earned leave up to 10 days on each occasion and a maximum of 60 days in the entire service are permissible. A balance of at least 30 days Earned Leave may be available to his/her credit after taking into account the period of encashment as well as leave. The encashment so availed will be taken into account while computing the maximum admissible for encashment at the time of quitting service. ";
            case "Half Pay Leave":
                return "All permanent employees of the Institute are eligible for 20 days Half Pay Leave for each completed year of service in the Institute. The service includes periods of duty and leave including extra ordinary leave with or without medical certificate, but does not include periods of suspension treated as dies non, overstayed of leave and joining time unless otherwise regularized." +
                "\n" + "  1. Every employee shall be credited with half pay leave in advance, in two installments of 10 days each on the 1st January and 1st July of every calendar year." +
                "\n" + "  2. The leave shall be credited to the account at the rate 5/3 days for each completed calendar month of service which the employee is likely to render in the half year of the calendar year in which the employee is appointed." +
                "\n" + "  3. The half pay leave to be credited every half-year will be reduced at the rate of one-eighteenth of the period of dies non/ suspension treated as dies non, during the preceeding half-year, subject to a maximum of ten days." +
                "\n" + "  4. Half pay leave credit for the half-year which the employee retires / resigns / removed / dismissed or dies in service will be afforded at the rate of 5/3 days per completed calendar month up to the end of the month preceding the last calendar month of service. Any fraction shall be rounded off to the nearest day." +
                "\n" + "  5. Half pay leave may be availed of either on medical ground or on medical certificate or on private affairs." +
                "\n" + "  6. Half pay leave may be granted even when Earned Leave is due/at credit to an employee." +
                "\n" + "  7. Head of the Department/ Centre/ Section shall forward the Half pay leave request to the Establishment / Registrar for approval and records.";
            case "Leave Not Due":
                return "Leave Not Due may be granted to a permanent employee with no half pay leave at his / her credit on medical grounds (with medical certificate) only. This is granted by the Director if there is a reasonable prospect of the employee returning to duty on expiry of the leave." +
                "\n" + "  1. The amount of leave should be limited to the half pay leave that the employee is likely to earn subsequently. Leave Not Due during the entire service is limited to a maximum of 360 days." +
                "\n" + "  2. Leave Not Due may be granted without medical certificate to a female employee in continuation of maternity leave or to a female Government servant with less than two living children on adoption of a child less than a year old." +
                "\n" + "  3. Leave Not Due will be debited against the half pay leave that the employee earns subsequently." +
                "\n" + "  4. Leave Not Due may also be granted to temporary employees with minimum one- year service suffering from TB, Leprosy, Cancer or Mental illness for a period not exceeding 300 days if the post from which the employee proceeds on leave is likely to last till his/her return." +
                "\n" + "  5. An employee granted Leave Not Due resigns from the Institute or is permitted to retire voluntarily without returning to duty, the Leave Not Due should be cancelled. The resignation / retirement / will take effect from the date on which such leave had commenced and the leave salary should be recovered." +
                "\n" + "  6. The Head of the Department/ Centre/ Section may forward the request to the Director or authority nominated by Director with proper medical certificate/recommendation through the HoD.";
            case "Maternity Leave":
                return "Maternity Leave is a special kind of leave applicable to all female employees of the Institute." +
                "\n" + "  1.  A female employee of the Institute with less than 2 surviving children be granted Maternity Leave for a period of 180 days." +
                "\n" + "  2.  During maternity leave, she shall be paid leave salary equal to the pay drawn immediately before proceeding on leave." +
                "\n" + "  3.  Maternity Leave not exceeding 45 days may also be granted to a female employee (irrespective of the number of surviving children) during the entire service of that female employee in case of miscarriage including abortion on production of medical certificate issued by Registered Medical Practitioner. " +
                "\n" + "  4.  Leave of the kind due and admissible (including Commuted Leave for a period not exceeding 60 days and Leave Not Due) up to a maximum of two years may, if applied for, be granted without medical certificate in continuation of Maternity Leave." +
                "\n" + "  5.  Maternity Leave may be combined with leave of any other kind." +
                "\n" + "  6.  Maternity Leave shall not be debited against the leave account." +
                "\n" + "  7.  Counts as service for increments – FR 26 (B)." +
                "\n" + "  8.  Counts as service for pension – Rule 21 of CCS (Pension) Rules." +
                "\n" + "  9.  Not admissible for ‘threated abortion’ – Rule 43, GID (4)." +
                "\n" + "  10. Admissible for ‘induced abortion’ – Rule 43, GID (2)." +
                "\n" + "  11. The leave applications forwarded through the Department/ Centre/ Section to the Registrar for approval and records.";
            case "Adoption Leave":
                return "Adoption Leave is a special kind of leave applicable to female employees of the Institute." +
                "\n" + "  1. Granted to a female employee, with fewer than thwo surviving children, on valid adoption of a child below the age of one year, for a period of 180 days immediately after the date of valid adoption from 22 - 07 - 2009. Child includes a child taken as ward under the Guardians and Wardsl Act, 1890 subject to conditions." +
                "\n" + "  2. During Adoption Leave, the employee shall be paid leave salary equal to the pay drawn immediately before proceeding on leave." +
                "\n" + "  3. Adoption Leave may be combined with leave of any other kind." +
                "\n" + "  4. Adoption Leave is not available to an employee already having two living children at the time of adoption." +
                "\n" + "  5. The maximum admissible period of Adoption Leave will be regulated as" +
                "\n" + "    (a) If the age of the adopted child is less than one month, leave up to one year may be allowed." +
                "\n" + "    (b) If the age of the adopted child is 2-6 months, leave up to 6 months be allowed." +
                "\n" + "    (c) If the age of the adopted child is 7-10 months, leave up to 3 months may be allowed." +
                "\n" + "  6. The applications with relevant adoption documents be forwarded through the Department/ Centre/ Section to the Registrar for approval and records.";
            case "Work Related Injury or Illness Leave":
                return "Work Related Illness and Injury Leave is a special kind of leave applicable to group IV employees and group III employees whose duties involve the handling of dangerous machines, explosive materials, poisonous drugs and the like or the performance of hazardous tasks." +
                "\n" + "  1. Full pay and allownces will be granted to all employees during the entire period of hospitalization on account of WRIIL." +
                "\n" + "  2. Beyond hospitalization, WRIIL will be governed as follows:" +
                "\n" + "    i. Full pay and allowances for the 6 months immediatesly following hospitalization and Half Pay only for 12 months beyond that." +
                "\n" + "    ii. The Half Pay period may be commuted to full pay with corresponding number of days of Half Pay Leave debited from the employee’s Leave account." +
                "\n" + "  3. No Earned leave or Half Pay Leave will be credited during the period that the employee is on WRIIL.";
            case "On Duty Leave":
                return "The Director or person delegated by the Director is empowered to grant maximum of 15 days in a calendar year." +
                "\n" + "  1. The following items / activity are treated as On Duty Leave." +
                "\n" + "    (a)  Attending a conference (national or international) for presenting a paper." +
                "\n" + "    (b)  Absence from the Institute to serve as an expert member for any committee formed by the MHRD / State Government / Central Government NIT Council." +
                "\n" + "    (c)  Absence from the Institute for official purpose in IITs / NITs / MHRD Office / AG’s Office or other places decided by the Director." +
                "\n" + "    (d)  For the principal investigator for attending meetings / visiting organizations which sanctions funded projects." +
                "\n" + "    (e)  For attending election duty arranged by the election commission." +
                "\n" + "  2. Director is authorized to sanction more days if any request, as and when it arises.";
            case "Special Case Leave":
                return "Special Casual Leave may also be granted to the employees for other purpose, as approved by the Director from time to time. The Special Casual Leave can be granted up to a maximum of 15 days in a calendar year. The Director is empowered to examine the purpose for which absence can be treated as On Duty and Special Casual Leave. An employee’s absence from the Institute can be marked as On Duty when the employee is doing Institute/Dept. work outside the Institute with the approval of the competent authority and not for any invitation from external source for personal lecture or viva exam or PhD evaluation or attending workshops or conferences." +
                "\n" + "  1.  Special Casual Leave can be granted to a member of the staff, when he/she is" +
                "\n" + "     (i) Summoned to serve as Juror or Assessor or to give evidence before a court of law as a witness in a civil or a criminal case in which his/her private interests are not at issue." +
                "\n" + "     (ii)  Deputed to attend a reference library of another Institute or conferences and scientific gatherings of learned and professional societies in the interest of the  Institute." +
                "\n" + "     (iii) Required to be absent for any other purpose approved by the Board of Governors." +
                "\n" + "  2.  Special Casual Leave may also be granted for other purposes, as approved by the Board from time to time. In case it exceeds the 15 days limitation, the cases of those staff have to be placed before the Board for further consideration. SCL may be granted for donating blood to recognized Blood Bandks on working day (for that day only)." +
                "\n" + "  3.  The Director is empowered to examine the purposes for which absence can be treated as On Duty and purposes for which SCL can be granted. The Director is also empowered to examine the possibility of advising the staff members to fix up programmes like conduct of Viva-Voce for Ph.D. on Saturdays or on holidays." +
                "\n" + "  4.  The additional purposes for which the Special Casual Leave can be granted, are specified below:" +
                "\n" + "     (i) To attend committee meetings, invited lectures without renumeration which are not treated as on duty." +
                "\n" + "     (ii)  To conduct Ph.D. Viva or an Examination." +
                "\n" + "  5.  Faculty members deputed by the institute in connection with the institute work will be treated as on duty and the period will not count towards SCL." +
                "\n" + "  6.  The absence of the faculty members in their efforts towards funds raising and building of corpus funds etc. will be regulated under SCL." +
                "\n" + "  7.  SCL shall be granted for other academic purposes from time to subject to the approval." +
                "\n" + "  8.  For participation in Sports Events, SCL is admissible up to a maximum of 30 days in a calendar year like Coaching or Training camps of all India coaching or training schemes." +
                "\n" + "  9.  To give special lectures with honoraruim, the faculty member must take leave at credit. No SCL is admissible. " +
                "\n" + "  10. SCL may also be granted to re-employed disabled Military Pensioners when called upon to attend Resurvey Medical board to assess their disability element." +
                "\n" + "  11. SCL is admissible upto a maximum of 10 days in any one year for participating in inter-Ministerial and iner-Departmental tournaments and sporting events." +
                "\n" + "  12. SCl may also be granted to sportsperson getting seriously injured or being hospitalized during Sporting events subject to the overall ceiling of 30 days in a calendar year." +
                "\n" + "  13. SCL is admissible to 30 days in one calendar year for participation in cultural activities like dance, drama, music, poetic symposium etc., of an All India, or Inter-State character organized by or on behalf of the Central Secretariat Sports Control Board or on its behalt. SCL will not be admissible for practice or for participation in cultural activities organized locally." +
                "\n" + "  14. SCL is admissible to employees participating in dancing and singing competitions at Regional, National or International level, organized by GOI or Govt. Sponsored Bodies subject to maximum of 15 days in a calender year." +
                "\n" + "  15. SCL upto a maximum of 15 days in a year is admissible for visit in connection with the consultancy and sponsored research activities." +
                "\n" + "  16. SCL upto a maximum of 12 days in a year is admissible to the office bearers of recognized Unions/ Association to attend meetings." +
                "\n" + "  17. SCL shall be granted to the staff of the Institute when thery are unable to attend office due to natural calamitits/ bandh etc. subject to the approval of the authorities. SCL granted to be reported to the ministry." +
                "\n" + "  18. Combination of Casual or regular leave (e.g., EL, HPL, etc.) with SCL is permissible but combination of both CL and regular leave with SCL is not permissible." +
                "\n" + "  19. LTC can also be availed of during Special Casual Leave." +
                "\n" + "  20. For family planning:" +
                "\n" + "     a) Male Employee:" +
                "\n" + "       1. Maximum of 6 working days admissible for vasectomy operation. If he undergoes the said operation for second time due to failure of the first, another 6 days will be admissible on the production of medical certificate." +
                "\n" + "       2. Maximum of 21 days for undergoing recanalization operation." +
                "\n" + "       3. Maximum of 7 days if his wife undergoes tubectomy, laproscopy of salpingectomy operation. The leave should follow the date of operation." +
                "\n" + "     b) Female Employee:" +
                "\n" + "       1. Maximum of 14 days admissible for tubectomy / laproscopy. If she undergoes the said operation for a second time due to failure of the first, maximum of 14 days will be admissible for the second time." +
                "\n" + "       2. Maximum of 14 days admissible for salpingectomy operation after Medical Termination of Pregnancy (MTP)." +
                "\n" + "       3.  Admissible for one day on the day of IUCD / IUD insertion / reinsertion. " +
                "\n" + "       4.  Maximum of 21 days admissible for undergoing recanalization operation." +
                "\n" + "       5. Admissible for one day on the day of operation when her husband undergoes vasectomy operation.";
            case "Vacation":
                return "During the period when the semester is closed (vacation period) Teaching staff (as per NIT Statutes) can avail vacation for 60 days. The Registrar will notify the vacation period, to enable the Teaching staff to avail vacation." +
                "\n" + "  1. Maximum vacation that can be taken is 60 days." +
                "\n" + "  2. 60 days vacation is arrived based on the academic year." +
                "\n" + "  3. The duration of winter vacation period and summer vacation period shall be notified by the Registrar based on the recommendations of the Dean (Academics)." +
                "\n" + "  4. No Teaching staff is allowed to take vacation other than the notified dates by the Registrar." +
                "\n" + "  5. Teaching staff, who remain on duty during the whole or part of the vacation, will be eligible to get one day earned leave for each two days of vacation not availed." +
                "\n" + "  6. Vacation can be suffixed or prefixed with any leave but the vacation and other leave combined should not exceed 180 days at a time." +
                "\n" + "  7. Teaching Staff who remains on duty during vacation period may be allowed to take any other leave except EL, like when they are on normal duty." +
                "\n" + "  8. If a staff member avails of any vacation half of that period will be debited from his/her EL account." +
                "\n" + "  9. A new faculty joining in the summer vacation period is not eligible for vacation during that summer.";
            case "Commuted Leave":
                return "All the permanent employees of the Institute is eligible for Commuted Leave not exceeding half the amount of Half Pay Leave due, may be granted on medical certificate." +
                "\n" + "  1.  The authority competent to grant leave is satisfied that there is reasonable prospect of the employee returning to duty on its expiry." +
                "\n" + "  2.  When commuted leave is granted, twice the amount of such leave shall be debited against the Half Pay Leave due." +
                "\n" + "  3.  Commuted leave can be granted without medical certificate up to a maximum of 90 days in the entire service if utilized for an approved course of study certified to be in public interest by the Registrar." +
                "\n" + "  4.  Commuted leave up to a maximum of 60 days can be granted, without medical certificate to a female employee if it is in continuation of maternity leave." +
                "\n" + "  5.  Commuted leave up to a maximum of 60 days can be granted without medical certificate to a female employee with less than 2 living children if she adopts a child less than one-year-old." +
                "\n" + "  6.  Commuted leave can be granted on the strength of a medical certificate from a hospital / medical authority registered with the Indian Medical Council." +
                "\n" + "  7.  Employees who join after availing the Commuted leave will have to submit fitness certificate from the hospital / medical authority registered with the Indian Medical Council." +
                "\n" + "  8.  Commuted leave can not be granted as a leave preparatory to retirement." +
                "\n" + "  9.  Commuted leave can be granted even when Earned Leave is available." +
                "\n" + "  10. Where an employee granted Commuted leave quits service voluntarily without returning to duty, the Commuted Leave shall be treated as Half Pay Leave and excess leave salary shall be recovered. However, ill health incapacitating the employee for further service or in the event of death, no such recovery should be made." +
                "\n" + "  11. Head of the Department/ Centre/ Section shall forward the leave request to the Establishment /Registrar for approval and records. ";
            case "Extra Ordinary Leave":
                return "Extra Ordinary Leave may be granted to an employee when no other leave is admissible or when the employee applies in writing for the grant of Extra Ordinary Leave when other leave is admissible." +
                "\n" + "  1.  Extra Ordinary Leave shall always be without leave salary." +
                "\n" + "  2.  For temporary or contract employees; the duration of extra ordinary leave on any one occasion shall not exceed 3 months with or without medical certificate and 6 months when the employee has completed oneyear continuous service on the date of expiry of leave admissible to the employee under the rules and the request for such leave is supported by Medical Certificate." +
                "\n" + "  3.  Eighteen months extra ordinary leave can be granted to an employee suffering from TB, Leprosy, Cancer or Mental illness and undergoing treatment in a recognized clinic/hospital/under a specialist." +
                "\n" + "  4.  After completing 3 years of continuous service in the Institute an employee can avail 24 months extra Ordinary Leave for the purpose of pursuing studies certified to be in the public interest (leading to award of degree)." +
                "\n" + "  5.  The period of extra ordinary leave taken by an employee for illness on medical certificate will count for annual increments and qualifying service for terminal benefits as well. Extra ordinary Leave availed for all other purpose will not be counted for increment and terminal benefits; provided that in case of any doubt the decision of the Board shall be final." +
                "\n" + "  6.  Extra ordinary leave may be granted for the purpose of availing research fellowships or for pursuing higher studies leading to the award of a degree from Institution in India/abroad. Such requests forward through the HOD to the Director. Director is authorized to sanction Extra Ordinary Leave up to six months period; beyond, the Board approval is required." +
                "\n" + "  7.  Extra ordinary leave can be granted to employees for short term in India or abroad. Such assignments may include visiting faculty, technical expert / special officer / technical consultant or any other responsibilities approved by the Board. Extra Ordinary Leave of this type will not be eligible for counting of service or will not earn leave for that period and will also not be eligible for notional increment." +
                "\n" + "  8.  A minimum of 5 years service in the Institute is essential for an employee to take extra ordinaty leave beyond six months, for other than study purpose." +
                "\n" + "  9.  An employee will be eligible for extra ordinary leave at the rate of one year for every 5 years of service put in at this institute except for higher studies leading to the award of a degree. Pension Contribution/PF Contribution as per rules shall be paid either by the employer or by the employee concerned to the Institute during the period of extra ordinary leave, where ever it is required as per rules." +
                "\n" + "  10. Any single occasion, an employee can avail extra ordinary leave for a maximum of 2 years for clause 3.8.7. Also, there must be a minimum interval of 3 years between 2 consecutive Extra Ordinary Leave with duration of which exceeds 6 months." +
                "\n" + "  11. A bond is to be executed to the Institute to serve the Institute for a period of" +
                "\n" + "    a) 1 year for EOL  up to 6 months" +
                "\n" + "    b) 2 years for EOL  6 months to one year" +
                "\n" + "    c) 3 years for EOL  beyond one year on completion of the extra ordinary leave." +
                "\n" + "  12. At any point of time, in Department a maximum of 15% of the sanctioned strength of the faculty of the Departments, may be permitted to avail any of the leave under QIP and extra ordinary leave for study purpose (etc put together)";
            case "Paternity Leave":
                return "The Paternity Leave is a special kind of leave applicable only to the male employees of the Institute." +
                "\n" + "  1. A married male employee with less than two surviving children be granted Paternity Leave for a period of 15 days." +
                "\n" + "    (a) During the confinement of his wife for child birth, up to 15 days before, or up to six months from the date of delivery of the child." +
                "\n" + "    (b) On valid adoption of a child below the age of one year, within 6 months from date of valid adoption." +
                "\n" + "  2. During Paternity Leave, the employee shall be paid salary equal to the pay drawn immediately before proceedings on leave. " +
                "\n" + "  3. Paternity Leave may be combined with leave of any other kind except casual Leave. Paternity Leave shall not be debited against the leave account." +
                "\n" + "  4. If Paternity Leave is not availed within the period specified, Paternity Leave shall be treated as lapsed." +
                "\n" + "  5. Paternity Leave applications are to be forwarded through the Department/ Centre/ Section to the Registrar for approval and records." +
                "\n" + "  6.  Child includes a child taken as ward under the Guardians and Wards Act, 1890 subject to conditions. – Rule 43-AA, Note 2.";
            case "Child Care Leave":
                return "Child Care Leave is a special kind of leave for women employees of the Institute to take care of their children at the time of need." +
                "\n" + "  1.  Women employees having minor children be granted Child Care Leave for a maximum period of 730 days during their entire service for taking care of up to two children whether for rearing or to look after any of their needs like examinations, sickness etc. CCL extented to single male (parent) employee also." +
                "\n" + "  2.  Child Care Leave cannot be demanded as a matter of right. Under no circumstances can any employee proceed on Child Care Leave without prior proper approval of the leave by the competent authority. Child Care leave will be granted only on 3 spells in a calendar year." +
                "\n" + "  3.  Child Care Leave shall be admissible for two eldest surviving children only." +
                "\n" + "  4.  For availing the Child Care Leave, the age of the child should be 18 years or below. However, age up to 22 year is admissible for disabled child. Documents relating to the disability as well as a certificate from the employee regarding dependency of the child would have to be submitted." +
                "\n" + "  5.  There is no requirement of minimum period for grant of Child Care Leave. " +
                "\n" + "  6.  Child Care Leave may be granted for even less than 15 days at any spell However not leas than 5 days at a time. " +
                "\n" + "  7.  Child Care Leave is to be treated like Earned Leave and sanctioned as per approving authorities and such records are to be kept in the Registrar Office / Establishment and for all other employees by the Registrar. Prior approval is required for taking CCL of more than 15 days; such cases, the employee must apply for CCL at least 10 days in advance." +
                "\n" + "  8.  Child Care Leave should not ordinarily be granted during the probation period except in case of certain extreme situations where the Director/ Registrar is fully satisfied about the need of Child Care Leave to the probationer. It may also be ensured that the period for which this leave is sanctioned during probation is minimal." +
                "\n" + "  9.  Child Care Leave may also be allowed for the third year as Leave Not Due and commuted leave upto 60 days (without production of medical certificate)." +
                "\n" + "  10  Child Care Leave may be combined with leave of the kind due and admissible except Casual Leave." +
                "\n" + "  11. During Child Care Leave, the employee shall be paid leave salary equal to the pay drawn immediately before proceeding on leave." +
                "\n" + "  12. Child Care leave should be granted at 100% of salary for first 365 days and 80% of salary for next 365 days (para 9.2.9 of VII CPC Report)." +
                "\n" + "  13. Intervening holidays will count as Child Care Leave as in the case of EL. LTC cannot be availed during CCL." +
                "\n" + "  14. Child Care leave may be granted to single mothers for six spells in a calendar year.";
        }

        return "";
    }
}