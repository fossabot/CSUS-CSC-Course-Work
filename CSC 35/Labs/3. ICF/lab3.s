# Lab3.s
# Marc Woodyard
# as -o lab3.o lab3.s && ld -o a.out lab3.o csc35.o && a.out

.data     

question1:
    .ascii "How many daily units does the patient take?\n\0" 
    
response1:
    .ascii "\nThe patient's ICF is: \0" 
    
question2:
    .ascii "\n\nWhat is the patient's blood sugar level?\n\0" 
  
response21:
    .ascii "\nThe patient needs \0" 
    
response22:
    .ascii " unit(s).\n\0"
  
.text                         
.global _start                     

_start: 
  
    #Print the first question.
    mov $question1, %rax              
    call PrintCString  
    
    #Get the daily units.
    call ScanInt 
    mov %rax, %rbx

    #Divide to get the ICF.
    mov $1800, %rax
    div %rbx

    #Save value for later.
    mov %rax, %r15

    #Print the response.
    mov $response1, %rax
    call PrintCString
    mov %r15, %rax
    call PrintInt
    mov %rax, %r15
    
    #Ask question 2.
    mov $question2, %rax
    call PrintCString
    
    #Get the blood sugar level.
    call ScanInt 
    mov %rax, %r10
    
    #Get blood sugar level.
    mov $150, %r9
    sub %r9, %r10
    
    mov $response21, %rax
    call PrintCString
    
    mov %r10, %rax #120
    mov %r15, %rbx #30
    div %rbx
    
    call PrintInt
    
    mov $response22, %rax
    call PrintCString

    call EndProgram  
         
