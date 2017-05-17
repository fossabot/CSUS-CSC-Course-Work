# Exam 3 Study Guide

## Binary & Hex Numbers
[![IMAGE ALT TEXT HERE](https://img.youtube.com/vi/LpuPe81bc2w/0.jpg)](https://www.youtube.com/watch?v=LpuPe81bc2w)

[![IMAGE ALT TEXT HERE](https://img.youtube.com/vi/X98CaaVV7GQ/0.jpg)](https://www.youtube.com/watch?v=X98CaaVV7GQ)

## Notation (why important)
- Hexadecimal and binary notations use the same digits we use for decimal.
- As a result, some numbers look like valid hex, decimal and binary numbers.

> For example is **101** …<br/>
>    * binary value 5? <br/>
>    * decimal value 101? <br/>
>    * hexadecimal value 257? <br/>
>
> This, obviously, can become problematic.

- One notation is to use postfix character for binary and hexadecimal numbers.
- If no character is present, decimal is assumed.
```assembly
101h = 257 (hexadecimal)
101b = 5 (binary)
101 = 101 (decimal)
```

## ASCII
- 7 bits – 128 characters.
- Uses a full byte, one bit is not used.
- Alphabetic characters (uppercase and lowercase) are 32 "code points" apart.
- Uppercase and lowercase letters are just 1 bit different.

## Integers
- Integer data types are stored in simple binary numbers.
- The number of bytes used varies: 1, 2, 4, etc….

## Floating Point Numbers
- Floating point numbers are used to represent quantities that cannot be represented by integers.
- Regular binary numbers can only store whole positive and negative values.
- Many numbers outside the range representable within the system's bit width (too large/small).
- Floating-point numbers are usually stored using the IEEE 754 standard.
- Represent by a mantissa and an exponent
    - similar to scientific notation
    - the value of a number is: mantissa × 2exponent
    - uses signed magnitude

## Components of the Processor
**Execution Unit (EU)** - Performs calculations & logic / registers hold data.<br/>
    - **Arithmetic Logic Unit** - performs all calculations and comparisons.<br/>
**Control Logic Unit (CLU)** - reads and decodes instructions / talks to other components.<br/>

## Privileged mode
Privileged – Only the processor and OS can change it.

## Types of Operands
**Operation** – what to do.<br/>
**Operands** – what data is to be used.<br/>

- Registers
- Memory address
- Register pointing to memory
- A constant stored with the instruction – this is called an immediate.

## Types of Opcodes
- Data Transfer
- Program Flow Control
- Arithmetic and Logic operations
- Input and Output Instructions

## x86 Registers
```assembly
%ax %bx %cx %dx %si %di %bp %sp
%r8w %r9w %r10w %r11w %r12w %r13w %r14w %r15w
```
## Compilers
- Convert programs from high-level languages (such as C or C++) into assembly language
- Some create machine-code directly…

## Assemblers
- Converts assembly into the binary representation used by the processor.
- Often the result is an object file
- Usually not executable - yet
- Contains computer instructions and information on how to "link" into other executable units
- File may include: relocation data, unresolved labels, debugging data.

## Linkers
- A linker joins multiple parts (usually object files) into a single file.
- Connects labels (identifiers) - used in one object - to the object to that defines it.
- So, one object can call another object.
- What you will see: label conflicts and missing labels.

## Sign Magnitude
- One approach is to use the most significant bit (msb) to represent the negative sign.
- If positive, this bit will be a zero.
- If negative, this bit will be a 1.
- This gives a byte a range of -127 to 127 rather than 0 to 255.

## One's Complement
- Rather than use a sign bit, the value can be made negative by inverting each bit.
    - each 1 becomes a 0.
    - each 0 becomes a 1.
- Result is a "complement" of the original.
- This is logically the same as subtracting the number from 0.

## Two's Complement
- Practically all computers nowadays use 2's Complement.
- Similar to 1's complement, but after the number is inverted, 1 is added to the result.
- Logically the same as:
    - Subtracting the number from 2^n.
    - Where n is the total number of bits in the integer.

## Multiplication
[![IMAGE ALT TEXT HERE](https://img.youtube.com/vi/vJ_ZEkKLZ8M/0.jpg)](https://www.youtube.com/watch?v=vJ_ZEkKLZ8M)

## Division

[![IMAGE ALT TEXT HERE](https://img.youtube.com/vi/TPVFYoxna98/0.jpg)](https://www.youtube.com/watch?v=TPVFYoxna98)

## Sign Extension
- Simply adding zeroes to the left, will convert a negative value to a positive one.
- Add zero, but move the most signigignificant bit to the left. 


## Concept of flags
- A flag is a Boolean value that indicates the result of an action.
- These are set by various actions such as calculations, comparisons, etc…
- Flags are typically stored as individual bits in the Status Register.
- You can't change the register directly, but numerous instructions use it for control and logic.

#### x86 Flags Used by Compare
| Name | Description | When True |
| ------ | ------ | ------ |
| CF | Carry Flag | If an extra bit was "carried" or "borrowed" during math.|
| ZF | Zero Flag | All the bits in the result are zero. | 
| SF | Sign Flag | If the most significant bit is 1.
| OF | Overflow Flag | If the sign-bit changed when it shouldn’t have.

## How Jump Statements Work
#### Jump Equal
```assembly
cmp $13, %rax
je Equal
    ...

Equal:
    ...
```
#### Jump Greater or Equal
```assembly
mov $42, %rax
cmp $13, %rax
jge Bigger
    ...
Bigger:
    add $5, %rax
```


## How to implement If statement
```assembly
cmp $21, %rax
jl End
    #true block
    
End:
```

## Statements, While, For, Switch
#### While Loop
```assembly
While:
    cmp $21, %rax
    jl End
    
    #true block
    jmp While
End:
```

#### For Loop
```assembly
mov $0, %r15
For:
    cmp $3, %r15
    jl End              # When %r15 == 3, we're done.
    
    #Some code... :D
    
    jmp For             # %r15 != 3, jump back.
End:
```

#### Switch Statement
```assembly
    mov Party, %rax
    cmp $1, %rax
    je case_1
    cmp $2, %rax
    je case_2
    jmp default

case_1:
    call Democrat
    jmp End
case_2:
    call Republican
    jmp End
default:
    call ThirdParty
    
End:
```
## What is Memory (address, etc.…)
- Memory is essentially a long list of bytes.
- Memory is sometimes referred to as storage.
- This is because it stores both running programs and their related data.
- Memory is divided into a storage locations that can hold 1 byte (8 bits) of data.
- Each byte has an address
    - Unique value that refers to that specific byte.
    - Used to locate the exact byte the processor wants.
## Endianness
- Big-Endian approach - Store the most significant byte first.
- Little-Endian approach - Store the most significant byte last.

## Addressing Modes
- Immediate Addressing - A value is stored as part of the instruction.
```assembly
mov $7, %r15
```
- Register Addressing - A value is read from or stored into one of the processor's registers.
- Direct Addressing - Tthe processor reads data directly from RAM.
```assembly
.data
Total:
    .quad 0
.text
.global _start
_start:
    mov Total, %rax
```
- Register Indirect Addressing - Stores a RAM address in a register.<br/>
![IMAGE ALT TEXT HERE](https://raw.githubusercontent.com/MarcWoodyard/CSUS-CSC-Course-Work/master/CSC%2035/Images/Register%20Indirect%20Addressing.PNG)<br/>
- Relative Addressing - Used in conditional jump statements. The instruction only stores the value to add to the program counter.<br/>
![IMAGE ALT TEXT HERE](https://raw.githubusercontent.com/MarcWoodyard/CSUS-CSC-Course-Work/master/CSC%2035/Images/Relative%20Addressing.PNG)<br/>

## How Arrays Work
- When you create an array…
    - You allocate a block of memory.
    - Each element (cell) is located sequentially in memory – one right after each other.
    
- Start of our block of memory (buffer) is at address 2000.
- The first array cell is at 2000
- Arrays consists of bytes…
    - the second is at 2001
    - the third is at 2002
    - the fourth at 2003
    - etc…
> **Formula:** Start of Buffer + (Index * Size) 

## The Stack
- A stack is an abstract data structure that stores objects.
- Based on the concept of a stack of items – like a stack of dishes.
- Data can only be added to or removed from the top of the stack (First in Last Out).
```assembly
mov $7, %rax
push %rax       # Pushed to the stack.
pop %rax        # Poped from the stack.    
```

## Passing Parameters Using Registers
- Store data in registers, which can be use by your program.
```assembly
_start:
    mov $4, %rax
    mov $12, %rbx
    call AddIt
    add $1, %rbx
...
AddIt:
    add %rax, %rbx
    ret    
```

## Stack frames
- Rather than pass all parameters through registers, the system stack is used.
- The stack is also used to store local variables.
- Contains all the information needed by subroutine.
- Includes:
    - calling program's return address
    - input parameters to the subroutine
    - the subroutine’s local variables
    - space to backup the caller's register file

#### How it Starts Up
- Caller
    - pushes the subroutine's arguments onto the stack
    - caller calls the subroutine
- Subroutine then…
    - uses the stack to backup registers and "carve" out local variables.
   
#### How it Finishes
- Subroutine…
    - restores the original register values
    - removes the local variables from the stack
    - calls the processor "return" instruction
- Caller, then…
    - removes its arguments from the stack
    - handles the result – which can be p

## How They Work on the x86 (Stack Frames)
- The stack base on the x86 is stored in high memory and grows downwards towards 0.
- So, as the size of the stack increases, the stack pointer (RSP) will decrease in value.

#### Structure
    1. Push parameters
    2. Call the subroutine
    3. Save the old base pointer
    4. Add local variables
    5. Backup registers
```assembly
# Subroutine: Setup Example
push %rbp
mov %rsp, %rbp
push $1
push $2
push %rax
push %rbx

# Subroutine: Ending Example
pop %rbx
pop %rax
mov %rbp, %rsp
pop %rbp
ret
 ```   

## von Neumann Architecture
- Programs are stored and executed in memory.
- Separation of processing from storage.
- Different system components communicate over shared buses.

##### Buses
- Electronic pathway that transports data between components.
- Think of it as a "highway".
    - Data moves on shared paths.
    - Otherwise, the computer would be very complex.

##### Address Bus
- Used by the processor to access a specific piece of data.
- This "address" can be...
        - A specific byte in memory
        - Unique IO port
        - etc…
##### Data Bus
- The actual data travels ove the data bus
- An integer that has the same number of bits as the system is called a word.
##### Control Bus
- The control bus controls the timing and synchronizes the subsystems.
- Specifies what is happening...
    -  Read data
    - Write data
    - Reset
    - etc...

## Operands
- The number of operands used in an instruction varies greatly by processor.
- More operands give greater functionality, but require more bits to store in memory.
- Typically processors contain 1, 2 or 3 operands.

##### Single Operand Processors
- Single operand processors are also known as accumulators.
- Operates similar to your hand calculator.
- The accumulator register.
    - Used for all mathematical computations.
    - Other registers simply are used to compare and hold temporary data.
```assembly
# z = 50 - (x + y)
load x
add y # x + y
store temp
load $50
sub temp # 50 – temp
store z
```
##### Two Operand Processors
- Allows two operands to be specified
- For computations, both operands are typically treated as input and one is used to store the result.
```assembly
# z = 50 - (x + y)
mov x, %R1
add y, %R1 # x + y
mov $50, %R2
sub %R1, %R2 # 50 – R1
mov %R2, z
 ```

##### Three Operand Processors
- Allows two input values like before, but also can specify a third output operand.
- The third operand can also be used as a index for simple addressing.

 ```assembly
# z = 50 - (x + y)
add x, y, %R1 # x + y
sub $50, %R1, z
 ```

## CISC vs. RISC
- CISC - **C**omplex **I**nstruction **S**et **C**omputer
    - Hardware should contain the complexity rather than the software.
        ##### Why CISC?
        - Better preformance.
        - Eaiser to Compile.
        - Generally requires fewer instructions than RISC to perform the same computation.
        - Programs written for CISC architectures tend to take less space in memory.
- RISC - **R**educed **I**nstruction **S**et **C**omputer (RISC)
    - Software should contain the complexity rather than hardware.
        ##### Why RISC?
        - Simpler instructions make it easier to implement on different processors – and make them more efficient.
        - Easier to program and master by programmers – less to learn.
        - Memory access is minimalized.

## Instruction Encoding
- Each instruction on a computer is encoded into 1's and 0's.
- All information that needs to be stored, has to be converted to bits.
- Instructions can either be stored using a variable-length or fixed number of bytes.
- The opcode contains a unique value that indicates the operation to be performed.

 ```assembly
ADD %r1, %r2    ---->     0100 01 10

0100 - Opcode for add
01  - Register %r1
10  - Register %r2
 ```

## Multiprogrammed
- Most computers support multiprogramming (aka multitasking)
- Presents the illusion that multiple programs are running simultaneously on a computer.
- **Each program executes for a fixed amount of time, known as a timeslice**.
- User programs do not know if other programs are running on the system.

## Timeslice and Context Switch
#### Timeslice
- **Each program executes for a fixed amount of time, known as a timeslice**.
#### Context Switch
- When a program's time slice ends…
    1. Operating system stops it.
    2. Copies the contents its register file into memory.
    3. Removes it from the processor.
    4. Copies the next program's register file out of memory and into the register file.
    5. Loads next program into the processor.
- **This process known as a context switch.**

## Kernal

- Kernal – the core of the operating system.

## Vector Tables
- Often an application (or a piece of hardware) needs to talk to the operating system.
    ##### Examples:
    - Software needs the OS to output data.
    - USB port notifies the OS that a device was plugged in.
    ##### How Does This Work?
    1. When interrupted, the processor looks up the number in the "vector table".
    2. Table contains the address of the subroutine to execute.
    3. The interrupt number is an index into this table.
    4. When interrupted, the processor uses the interrupt number (index into the table) and looks up the address.
    5. It then executes that address.
        - *(like a function you call in your Java programs)*

## Interrupts

- Interrupt Instruction allows your program to "interrupt" itself and pass information to the operating system kernal.
- Applications do not know where (in memory) to contact the kernal – so they ask the processor to do it.
    ##### How it Works:
    1. fill registers with values that will tell Linux what do to.
    2. call Linux by using interrupt 0x80 (or a special software interrupt instruction).
        ```assembly
        INT 0x80
        SYSCALL
        ```

## 5 Stages of Execution

1. **Fetch** an instruction from memory.
    -  First, the processor fetches the instruction from the memory.
    - The result is stored in the Instruction Register.
    - known as Instruction Fetch (IF).
2. **Decode** it to determine what it is.
    - Second, the instruction is decoded to determine what it is and its operands.
    - Signals are sent to the execution unit as input.
    - Formally known as Instruction Decode (ID).
3. **Read** the inputs from registers / memory.
    - The Execution Unit then reads the values of the instruction.
    - These can be in located in the instruction itself (immediate), register file, and from memory
    - Formally known as Memory Access (Mem).
4. **Execute** for computations for instruction.
    - Decoded instruction and input values are passed to the ALU.
    - Depending on the complexity of the instruction, some computations require multiple clock cycles.
        - e.g. multiplication is requiresmore cycles and an add.
    - Formally: Execute (EX)
5. **Write** the result into the registers / memory.
    - Finally, the result is written back into the register / memory.
    - Processor also updates flags and other state information such as the Program Counter.
    - Formally known as Write Back (WB).

## Pipelining

- Pipelining is an technique where multiple instructions are executed at the same time.
    - Laundry example...
- This greatly improves the speed (and efficiency) of a system.

## Data hazards
- **Read-After-Write Hazard** - Caused when one instruction reads data before the previous one has written it.
- **Write-After-Read Hazard** -  Caused when one instruction writes data before the previous one has read it.
- **Write-After-Write Hazard** - Caused two instructions attempt to write data, and the later one writes it first.

#### Solutions:
- **Score Boarding** - Presence bit (p-bit) added to each register. 
    - p = 0 - Register locked, instruction is going to write data to this register.
    - P = 1 - Data avaliable to read.
- **Bypass Forwarding** - The result is forwarded to the next register's read stage.
    - Essentially, we pass the ALU output from the first instruction directly to the second instruction. We skip the register file.
    
## Jump hazards
> One instruction contains a conditional jump. Do we just execute the instructions after it? They may never run!
- Unconditional and conditional branches, create data dependencies between... 
    - Branch instruction and the instruction fetch stage of the pipeline.
    - Branch instruction computes the address of the next instruction - that the instruction fetch stage should fetch.

#### Flushing 
- After the conditional branch instruction is analyzed, the hardware changes the program counter.
- All the instructions in the pipeline are invalid (since they will not execute).
- These pipelines are flushed – data discarded and restarted.
- Naturally, this causes a huge delay for the new pipeline's startup latency
- So, conditional branch penalty has a huge effect on processor performance.
![IMAGE ALT TEXT HERE](https://raw.githubusercontent.com/MarcWoodyard/CSUS-CSC-Course-Work/master/CSC%2035/Images/Flush%20-%20Jump%20Hazards.PNG)<br/>
