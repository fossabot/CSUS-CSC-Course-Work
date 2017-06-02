# lab1.s
# Marc Woodyard
#
# 1. Assemble : as -o lab1.o lab1.s
# 2. Link     : ld -o a.out lab1.o csc35.o
# 3. Execute  : a.out
#
# as -o lab1.o lab1.s && ld -o a.out lab1.o csc35.o && a.out

.data                               # Star the sata section.
Message:                            # Message is an address.
    .ascii "Hello Dr. Sugar!\n\0"   # Create a buffer of ASCII.

Text:
    .ascii "My name is Marc Woodyard.\n\0"

M1:
    .ascii "I havent had a checkup in \0"

M2:
    .ascii " months.\n\0"
    
Qoute:
    .ascii "Life is short. Smile.\n\0"

.text                               # Start the text section.
.global _start                      # Make the _start label public.

_start:                             # UNIX starts here.
    mov $Message, %rax              # Put the address into rax.
    call PrintCString               # Execute the csc35.o subroutine.

    mov $Text, %rax
    call PrintCString

    mov $M1, %rax
    call PrintCString

    mov $7, %rax
    call PrintInt

    mov $M2, %rax
    call PrintCString

    mov $Qoute, %rax
    call PrintCString

    call EndProgram                 # Execute the csc35.o subroutine.
