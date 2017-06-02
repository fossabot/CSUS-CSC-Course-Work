# Lab4.s
# Marc Woodyard
# as -o lab4.o lab4.s && ld -o a.out lab4.o csc35.o && a.out

.data     

title:
    .ascii " Are You Going to Die Estimator \n\0" 

question1:
    .ascii "\nDo you cross a street without looking? (y/n): \n\0" 
    
question2:
    .ascii "\nHave you ever put a piece of metal in an electrical outlet? (y/n): \n\0" 
    
question3:
    .ascii "\nDo you text and drive? (y/n): \n\0" 
    
question4:
    .ascii "\nDo you eat thing without looking at it first? (y/n): \n\0" 
  
question5:
    .ascii "\nAre you already dead? (y/n): \n\0" 
    
result1:
    .ascii "\nYou have a \0" 
    
result2:
    .ascii "% chance of dying a horrible death. \0" 
    
answer:
     .byte 'y'
  
goodyTwoShoes:
    mov $0, %rax
    jmp displayResults
    
badResults:
    .ascii "(╯°□°）╯︵ ┻━┻    <- (Guy flipping table).\n\0"
goodResults:
    .ascii "\\ (•◡•) /  YAAAAA!!!\n\0" 
    
.text                         
.global _start 

_start:

    mov $0, %r15                  # Set the default total.
    
    call VTClearScreen            # Clear the screen.
    
    mov $1, %rax                  # Make the program title pretty.
    call VTSetBackColor

    mov $title, %rax              # Print the program title.           
    call PrintCString
    
    mov $0, %rax                  # Set the background to default.
    call VTSetBackColor
    
    #-----------------------------------------------------------------------------
    
    mov  $question1, %rax         # Ask question 1.
    call PrintCString             # Print question to the screen.
    call ScanChar                 # Get the user's answer.
    movb answer, %ah              # Move answer to register %ah
    cmp  %ah, %al                 # Is answer == to %al?
    jne  Question2                # False, jump to done.
    add  $1, %r15                 # Add the value to the user's score.
    
    #--------------------------
    Question2:
    #--------------------------
    mov  $question2, %rax         # Ask question 2.  
    call PrintCString             # Print question to the screen.
    call ScanChar                 # Get the user's answer.
    movb answer, %ah              # Move answer to register %ah
    cmp  %ah, %al                 # Is answer == to %al?
    jne  Question3                # False, jump to done.
    add  $3, %r15                 # Add the value to the user's score. 
    
    #--------------------------
    Question3:
    #--------------------------
    mov  $question3, %rax         # Ask question 3.  
    call PrintCString             # Print question to the screen.
    call ScanChar                 # Get the user's answer.
    movb answer, %ah              # Move answer to register %ah
    cmp  %ah, %al                 # Is answer == to %al?
    jne  Question4                # False, jump to done.
    add  $2, %r15                 # Add the value to the user's score. 

    #--------------------------
    Question4:
    #--------------------------
    mov  $question4, %rax         # Ask question 4.  
    call PrintCString             # Print question to the screen.
    call ScanChar                 # Get the user's answer.
    movb answer, %ah              # Move answer to register %ah
    cmp  %ah, %al                 # Is answer == to %al?
    jne  Question5                # False, jump to done.
    add  $4, %r15                 # Add the value to the user's score. 

    #--------------------------
    Question5:
    #--------------------------
    mov  $question5, %rax         # Ask question 5.  
    call PrintCString             # Print question to the screen.
    call ScanChar                 # Get the user's answer.
    movb answer, %ah              # Move answer to register %ah
    cmp  %ah, %al                 # Is answer == to %al?
    jne  Calculate                # False, jump to done.
    add  $100, %r15               # Add the value to the user's score. 

     
    #--------------------------
    Calculate:
    #--------------------------
    mov  $1, %rax                  # Make the output result pretty.
    call VTSetBackColor
    mov  $result1, %rax            # Print out the result.
    call PrintCString

    cmp $0, %r15                   # Answer no to every question.
    je  goodyTwoShoes

    
    mov  $10, %rax
    CQO
    mov  %r15, %rbx
    idiv %rax
    mov %rbx, %rax
    
    cmp $0, %rax
    je  remainder
    jmp qoutent
    
    #--------------------------
    remainder:
    #--------------------------
    mov  %rdx, %rbx
    mov  $10, %rax               # Turn it into a percent.
    imul %rbx, %rax
    
    #--------------------------
    qoutent:
    #--------------------------
    mov  %rax, %rbx
    mov  $10, %rax               # Turn it into a percent.
    imul %rbx, %rax

    #--------------------------
    displayResults:
    #--------------------------
    call PrintInt                 # Print the precent.
    mov  $result2, %rax           # Print the second part of the result.
    call PrintCString
    cmp  $0, %r15
    jne  printBadResults
    mov  $goodResults, %rax
    call PrintCString
    jmp  endProogram
    
    #--------------------------
    printBadResults:
    #--------------------------
    mov  $badResults, %rax
    call PrintCString
      
    #--------------------------
    endProogram:
    #--------------------------
    mov  $0, %rax                 # Set the background to default.
    call VTSetBackColor
    
    call EndProgram