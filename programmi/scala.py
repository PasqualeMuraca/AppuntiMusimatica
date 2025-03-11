from music21 import scale, stream, note

def crea_scala(tonica, tipo):
    """
    Crea una scala musicale data una tonica e un tipo di scala.
    
    :param tonica: Nota iniziale della scala (es. 'C', 'D#', 'F')
    :param tipo: Tipo di scala ('major', 'minor', 'harmonicMinor', 'melodicMinor', ecc.)
    :return: Stream musicale contenente la scala
    """
    try:
        # Seleziona il tipo di scala
        if tipo == 'major':
            my_scale = scale.MajorScale(tonica)
        elif tipo == 'minor':
            my_scale = scale.MinorScale(tonica)
        elif tipo == 'harmonicMinor':
            my_scale = scale.HarmonicMinorScale(tonica)
        elif tipo == 'melodicMinor':
            my_scale = scale.MelodicMinorScale(tonica)
        else:
            print("Tipo di scala non riconosciuto. Uso scala maggiore di default.")
            my_scale = scale.MajorScale(tonica)

        # Creazione dello stream musicale
        s = stream.Stream()
        for p in my_scale.getPitches():
            s.append(note.Note(p))  # Converti Pitch in Note prima di aggiungerlo
        
        return s
    except Exception as e:
        print(f"Errore nella creazione della scala: {e}")
        return None

# Esempio di utilizzo
scala_do_maggiore = crea_scala('C', 'major')
if scala_do_maggiore:
    scala_do_maggiore.show('text')  # Visualizza le note della scala
    scala_do_maggiore.show('lily')  # Mostra lo spartito
