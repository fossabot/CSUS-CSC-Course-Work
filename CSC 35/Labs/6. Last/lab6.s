# Lab6.s
# Marc Woodyard
# as -o lab6.o lab6.s && ld -o a.out lab6.o && a.out

.data     

summer:
    .ascii "Have a great Summer Dr. S!\n" 
  
name:
    .ascii "My name is Marc Woodyard.\n"
    
plans:
    .ascii "I'm going to do nothing this summer.\n"

.text                         
.global _start 

_start:
  
  mov $1, %rax
  mov $1, %rdi
  mov $summer, %rsi
  mov $27, %rdx
  syscall

  mov $1, %rax
  mov $1, %rdi
  mov $name, %rsi
  mov $26, %rdx
  syscall

  mov $1, %rax
  mov $1, %rdi
  mov $plans, %rsi
  mov $38, %rdx
  syscall
  
  mov $60, %rax
  mov $0, %rdi
  syscall
  