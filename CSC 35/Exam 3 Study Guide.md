# Exam 3 Study Guide

## Binary & Hex Numbers

## Notation (why important)

## ASCII

## Integers

## Floating Point Numbers

## Components of the Processor

## Privileged mode
Privileged – only the processor and OS can change it.

## Types of Operands

## Types of Opcodes

## x86 Registers

## Compilers

## Assemblers

## Linkers

## Sign Magnitude

## One's Complement

## Two's Complement

## Multiplication

## Division

## Sign Extension

## Concept of flags
- A flag is a Boolean value that indicates the result of an action.
- These are set by various actions such as calculations, comparisons, etc…
- Flags are typically stored as individual bits in the Status Register.
- You can't change the register directly, but numerous instructions use it for control and logic.

| Name | Description | When True |
| ------ | ------ | ------ |
| CF | Carry Flag | If an extra bit was "carried" or "borrowed" during math.|
| ZF | Zero Flag | All the bits in the result are zero. | 
| SF | Sign Flag | If the most significant bit is 1.
| OF | Overflow Flag | If the sign-bit changed when it shouldn’t have.

#### x86 Flags Used by Compare


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

## Endianness

## Addressing Modes

## How Arrays Work

## The Stack

## Passing Parameters Using Registers

## Stack frames

## How They Work on the x86 (Stack Frames)

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

## Jump hazards
