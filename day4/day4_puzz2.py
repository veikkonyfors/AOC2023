def day4_puzz2(input):
    with open(input, "r") as input:
        # Lue rivit tiedostosta ja tallenna ne listaan
        match_lines = input.readlines()
        match_lines = [line.strip() for line in match_lines]

        copies = []
        for line in match_lines:
            copies.append(1)

        for i, line in enumerate(match_lines):
            for n in range(1, int(line)+1):
                copies[i + n] += copies[i]

        print(copies)

        num_cards = 0
        for n in copies:
            num_cards += n

        print(num_cards)



# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    day4_puzz2('card_matches')
