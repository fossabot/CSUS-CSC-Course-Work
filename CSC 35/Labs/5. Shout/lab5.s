# Lab5.s
# Marc Woodyard
# as -o lab5.o lab5.s && ld -o a.out lab5.o csc35.o && a.out

.data     

instructions:
    .ascii "Enter a message: \0" 
    
result:
    .ascii "Result: \0"
    
userInput:
    .space 100 
    
.text                         
.global _start 

_start:
  
    mov  $instructions, %rax
    call PrintCString
    
    mov  $userInput, %rax
    mov  $100, %rbx
    call ScanCString

    call toLowerCase
      
    mov  $result, %rax
    call PrintCString
    mov  $userInput, %rax
    call PrintCString
    
    call EndProgram
    
    #-----------------------------------------------------------------------------
    
    #toLowerCase Sub Routine
    toLowerCase:
    #------------
    call LengthCString
    sub $1, %rax
    mov %rax, %r15
    
    #mov $1, %rdi
    mov $userInput, %r10 
      
      
    While:
      cmp $0, %r15
      jl  Done
      
      #End capitol letters
      cmp $90, %al
      jle toLower
      
      leaveAlone:

      sub $1, %r15
      jmp While
      
      toLower:
      #------------
      #Start capitol letters
      cmp $65, %al
      jg leaveAlone
        add $32, userInput(%r15)
        sub $1, %r15
        jmp While
         
      Done:
      #------------
      ret
      