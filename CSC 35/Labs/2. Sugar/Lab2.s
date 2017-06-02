# Lab2.s
# Marc Woodyard
#
# 1. Assemble : as -o lab2.o lab2.s
# 2. Link     : ld -o a.out lab2.o csc35.o
# 3. Execute  : a.out
#
# as -o lab2.o lab2.s && ld -o a.out lab2.o csc35.o && a.out

.data                                                  
cookie1:                                               
    .ascii "Chocolate Chunk:   10 carbs per cookie\n\0"   

cookie2:
    .ascii "Marshmello Smore:  8 carbs per cookie\n\0"

cookie3:
    .ascii "Chocolate Brownie: 9 carbs per cookie\n\n\0"
   
question1:
    .ascii "How many Chocolate Chunk cookies?\n\0"
    
question2:
    .ascii "How many Marshmello Smore cookies?\n\0"
    
question3:
    .ascii "How many Chocolate Brownie cookies?\n\0"
    
conclusion1:
  .ascii "Wow! That's a total of \0"
 
conclusion2:
  .ascii " carbs!\n\0"

.text                         
.global _start                     

_start:                             
    mov $cookie1, %rax              
    call PrintCString               

    mov $cookie2, %rax
    call PrintCString

    mov $cookie3, %rax
    call PrintCString
  
    mov $question1, %rax
    call PrintCString
    
    #Get the number of cookie 1.
    call ScanInt
    imul $10, %rax
    mov %rax, %r15

    mov $question2, %rax
    call PrintCString
    
    #Get the number of cookie 2.
    call ScanInt
    imul $8, %rax
    mov %rax, %r14
    
    mov $question3, %rax
    call PrintCString
    
    #Get the number of cookie 3.
    call ScanInt
    imul $9, %rax
    mov %rax, %r13
    
    mov $conclusion1, %rax
    call PrintCString
    
    #Print the total number of carbs consumed.
    add %r14, %r15
    add %r13, %r15
    mov %r15, %rax
    call PrintInt
    
    mov $conclusion2, %rax
    call PrintCString
   
    #End Program
    call EndProgram              
