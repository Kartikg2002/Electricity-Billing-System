# Electricity-Billing-System
This is my Second project using JAVA core ,JDBC, and SQL(Electricity Billing System).

# Summary Of this project ------

1 SPLASH FRAME - LOGIN FRAME OPEN.


2 LOGIN FRAME - a) LOGIN BUTTON - CHECKS THE USERNAME,PASSWORD AND ACCOUNT TYPE WITH SIGNUP TABLE
                                  THEN OPEN THE PROJECT FRAME WITH PASSING OF meter number and 
                                  usertype.
                
                b) CANCEL BUTTON - CLOSE THE FRAME

                c) SIGNUP BUTTON - OPEN THE SIGNUP FRAME.


3 SIGNUP FRAME - a) CREATE BUTTON - STORE THE INFORMATION IN THE SIGNUP TABLE OF ADMIN OR CUSTOMER
                                    (ONLY USERNAME AND PASSWORD).
         
                 b) BACK BUTTON - BACK TO THE LOGIN FRAME.
 
                 NEW THINGS - # IN PANEL WE SET THE BORDER.

                              # FOCUS LISTENER ADD ON METERNUMBER TEXT FIELD,IF FOCUS LOST THE NAME
                                TEXTFIELD AUTOMATICALLY FILLED WITH THE NAME CORRESPONDING TO THAT
                                METERNUMBER IN THE SIGNUP TABLE.

                              # ITEM LISTENER ADD ON ACCOUNT TYPE COMBO BOX.IF THE ITEM STATE
                                CHANGED AND SET TO CUSTOMER,THEN THE METER NUMBER AND METER NUMBER
                                FIELD SET VISISBLE (TRUE) AND NAMETEXT.SET EDITABLE(FALSE).


4 PROJECT FRAME - a) JMENUBAR
                  b) JMENU
                  c) JMENUITEM(ADD ACTION LISTENER)

                  NEW THINGS - setExtendedState(JFRAME.MAXIMIZE_BOTH);
                               setMnemonics();
                               setAccelerator();
                     
                 JMENUITEM OPENS ALL THE NEXT FRAMES.


5 NEW CUSTOMER FRAME - a) NEXT BUTTON - FILL ALL THE DETAILS OF CUSTOMER FRAME INTO CUSTOMER
                                        TABLE AND (NAME AND METER NUMBER IN SIGNUP TABLE)
                                       
                                        OPENS THE METERINFO FRAME WITH meternumber PASSING.
                       
                       b) CANCEL BUTTON - (CLOSE THE PAGE)


6 METER INFORMATION FRAME - a) SUBMIT BUTTON - METERINFO FRAME INFORMATION ADDED INTO THE
                                               METERINFO TABLE


7 CUSTOMER DETAILS - NEW THINGS - # table .setModel(DBUTILS.resultsetToTabelModel(rs))


8 DEPOSIT DETAILS    -   a) SEARCH BY METERNUMBER
                         b) SEARCH BY MONTH
                         c) SEARCH BUTTON - FIND THE BILL CORRESPONDING TO METERNUMBER AND MONTH FROM
                                            THE BILL TABLE.


9 CALCULATE BILL     -   a) CLICK ON THE METERNUMBER(DETAILS FILLED  AUTOMATICALLY FROM THE NEW  
                                                     CUSTOMER TABLE.)
                         
                         b) SUBMIT BUTTON - TOTAL BILL CALCULATED FROM THE TAX TABLE AND ADD
                                            ALL THE INFORMATION OF CALCULATE BILL FRAME
                                            TO BILL TABLE.


10 UPDATE INFORMATION - a) UPDATE BUTTON - UPDATE THE NEW CUSTOMER TABLE
(meternumber PASSING)
                        b) BACK BUTTON


11 VIEW INFORMATION   -   FETCH THE INFORMATION FROM NEW CUSTOMER TABLE AND PRINT IN THE VIEW 
(meternumber PASSING)     INFORMATION FRAME.


12 PAY BILL           -   a) PAY BUTTON - UPDATE THE STATUS IN BILL TABLE TO PAID AND OPEN THE 
(meternumber PASSING)                     PAYTM FRAME


13 BILL DETAILS - SHOW THE BILL TABLE.
(meternumber PASSING)


14 GENERATE BILL - a) ADD PANEL
                   b) ADD TEXTAREA
                   c) ADD GENERATEBILL BUTTON


