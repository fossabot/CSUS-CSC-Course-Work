# Exam 3 Study Guide
> Binary & Hex Numbers

> Notation (why important)

> ASCII

> Integers

> Floating point numbers

> Components of the processor

> Privileged mode

> Types of operands

> Types of opcodes

> x86 Registers

> Compilers

> Assemblers

> Linkers

> Sign-magnitude

> One's complement

> Two's complement

> Multiplication

> Division

> Sign Extension

> Concept of flags

> How jump statements work

> How to implement If

> Statements, While, For, Switch

> What is memory (address, etc.…)

> Endianness
 
> Addressing modes

> How arrays work

> The stack

> Passing parameters using registers

> Stack frames

> How they work on the x86

> von Neumann architecture

> Operands

- The number of operands used in an instruction varies greatly by processor.
- More operands give greater functionality, but require more bits to store in memory.
- Typically processors contain 1, 2 or 3 operands.

##### Single Operand Processors
- Single operand processors are also known as accumulators.
- Operates similar to your hand calculator.
- The accumulator register.
    - Used for all mathematical computations.
    - Other registers simply are used to compare and hold temporary data.
```sh
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
```sh
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

 ```sh
# z = 50 - (x + y)
add x, y, %R1 # x + y
sub $50, %R1, z
 ```

> CISC vs. RISC
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

> Instruction Encoding
- Each instruction on a computer is encoded into 1's and 0's.
- All information that needs to be stored, has to be converted to bits.
- Instructions can either be stored using a variable-length or fixed number of bytes.
- The opcode contains a unique value that indicates the operation to be performed.

 ```sh
ADD %r1, %r2    ---->     0100 01 10

0100 - Opcode for add
01  - Register %r1
10  - Register %r2
 ```

> Multiprogrammed
- Most computers support multiprogramming (aka multitasking)
- Presents the illusion that multiple programs are running simultaneously on a computer.
- **Each program executes for a fixed amount of time, known as a timeslice**.
- User programs do not know if other programs are running on the system.

> Timeslice and context switch
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

> Kernal

- Kernal – the core of the operating system.

> Vector Tables
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

> Interrupts

- Interrupt Instruction allows your program to "interrupt" itself and pass information to the operating system kernal.
- Applications do not know where (in memory) to contact the kernal – so they ask the processor to do it.
    ##### How it Works:
    1. fill registers with values that will tell Linux what do to.
    2. call Linux by using interrupt 0x80 (or a special software interrupt instruction).
        ```sh
        INT 0x80
        SYSCALL
        ```

> 5 stages of execution

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

> Pipelining

- Pipelining is an technique where multiple instructions are executed at the same time.
    - Laundry example...
- This greatly improves the speed (and efficiency) of a system.

> Data hazards

> Jump hazards
