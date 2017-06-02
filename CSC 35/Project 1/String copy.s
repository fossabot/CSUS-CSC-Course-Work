.data

Input:
    .space 40         #Input buffer
    
Copy:
    .space 40         #Copy to buffer

.text
.global _start

_start:
    mov  $Input, %rax       #Address to write to
    mov  $40, %rbx          #Max bytes to read (so no buffer overflow)
    call ScanCString

    #rdi = 0;
    #while (rdi < 40)
    #{
    #    Copy[rdi] = Input[rdi];
    #    edi++;
    #}
    
    mov $0, %rdi               #edi = 0;
While:
    cmp  $40, %rdi             #(rdi < 40) 
    je   Done                  #Leave loop on false

    mov  Input(%rdi), %al      #Copy[rdi] = Input[rdi];
    mov  %al, Copy(%rdi)
    
    add  $1, %rdi              #rdi++;
    jmp  While
    
Done:
    #Let's print the copy
    mov  $Copy, %rax        #Address to read from
    call PrintCString
    
    call EndProgram