
INSERT INTO diseases (name, description, treatment)
VALUES ('SQLose Aiguë', 'Impossible de structurer ses tables SQL correctement',
        'Réécrire ses requêtes et boire 2 cafés par table'),
       ('Grippe Pixelisée', 'Vision pixelisée du monde', 'Mettre à jour ses drivers et prendre des vitamines'),
       ('Fièvre du 42', 'Température alignée avec le sens de la vie', 'Lire Douglas Adams et prendre du paracétamol'),
       ('Bug Crasheux', 'Redémarrage aléatoire, perte de mémoire intermittente', 'Redémarrer toutes les 4h'),
       ('Débogite Aiguë', 'Besoin compulsif de print() partout', 'Pratiquer TDD et respirer avant chaque commit'),
       ('Overclockite', 'Tachycardie due au café et pushs simultanés', 'Pause café obligatoire'),
       ('NullPointeritis', 'Oublie tout, tout le temps', 'Initialiser variables et consulter mentor'),
       ('Commitite Chronique', 'Commit compulsif', 'Créer branches et PRs'),
       ('Exception Non Gérée', 'Panique face aux imprévus', 'Ajouter try/catch dans sa vie'),
       ('Stack Overflow Syndrome', 'Trop d’infos, jamais fini', 'Faire des breaks fréquents'),
       ('Cachexia de Redis', 'Le patient oublie tout ce qui est stocké', 'Purger cache et vérifier backups'),
       ('Segfaultitus', 'Crash total du patient', 'Intervention chirurgicale immédiate'),
       ('Deadlockus Maximus', 'Blocage complet, aucune action possible', 'Opération de déverrouillage'),
       ('Merge Conflictitis', 'Fusion impossible entre deux états', 'Chirurgie de commit'),
       ('Infinite Loopitis', 'Patient répète la même action sans fin', 'Intervention pour casser la boucle'),
       ('StackOverflowitis', 'Trop de couches de comportement, patient s’effondre', 'Chirurgie mentale et reboot'),
       ('Panic Exception', 'Crise aiguë de panique face aux situations imprévues',
        'Intervention psychologique + chirurgie comportementale'),
       ('Memory Leak Syndrome', 'Le patient perd progressivement ses souvenirs récents',
        'Chirurgie neuronale et restauration de données'),
       ('Dead Thread', 'Patient incapable d’agir simultanément sur plusieurs tâches', 'Intervention multi-thread'),
       ('NullPointer Crisis', 'Patient ne trouve plus de repères, bloque tout', 'Chirurgie de réinitialisation');

INSERT INTO specialities (name, description)
VALUES ('Débogologie', 'Spécialité dédiée au diagnostic et à la correction des bugs logiciels.'),
       ('Pixelologie pédiatrique', 'Traitement des troubles visuels liés aux pixels chez les enfants.'),
       ('Neurostack', 'Étude et traitement des troubles neurologiques liés aux empilements de données.'),
       ('Cachethésie', 'Spécialité centrée sur les troubles de la mémoire cache.'),
       ('Fièvre 42logie', 'Traitement des fièvres existentielles et philosophiques.'),
       ('Chirurgie de commit', 'Interventions chirurgicales pour résoudre les conflits de versionnage.'),
       ('Psychiatrie des tests', 'Prise en charge des troubles mentaux liés aux tests logiciels.');

INSERT INTO speciality_diseases (speciality_id, disease_id)
VALUES (1, 1),
       (1, 4),
       (1, 5),
       (1, 7),
       (1, 8),
       (1, 9),
       (1, 10),
       (2, 2),
       (2, 15),
       (3, 3),
       (3, 6),
       (3, 11),
       (3, 16),
       (3, 18),
       (4, 6),
       (4, 11),
       (4, 19),
       (5, 3),
       (5, 10),
       (5, 17),
       (6, 12),
       (6, 13),
       (6, 14),
       (6, 15),
       (6, 16),
       (6, 18),
       (6, 19),
       (6, 20),
       (7, 5),
       (7, 8),
       (7, 9),
       (7, 17);

INSERT INTO surgery_types (name, description, duration_minute, operating_room)
VALUES ('Débogage profond',
        'Intervention chirurgicale pour retirer des bugs critiques dans le système nerveux du patient.',
        90, 'OR1'),

       ('Recompile du coeur',
        'Chirurgie visant à reconstruire les jonctions cardiaques mal formées après trop de commits.',
        120, 'OR2'),

       ('Cache flush abdominal',
        'Nettoyage des caches intestinaux pour corriger la perte de mémoire récente.',
        60, 'OR3'),

       ('Merge conflict cérébral',
        'Intervention sur le cortex pour résoudre des conflits internes entre neurones.',
        75, 'OR4'),

       ('Overclock du foie',
        'Réajustement métabolique après surcharge de café et pushes simultanés.',
        50, 'OR5'),

       ('Rollback gastrique',
        'Correction d’un estomac instable après ingestion de trop de syntaxe SQL.',
        40, 'OR6'),

       ('Patch cutané',
        'Petite chirurgie dermatologique pour réparer les erreurs de peau liées à un commit mal appliqué.',
        30, 'OR7'),

       ('Refactorisation musculaire',
        'Optimisation des muscles endoloris par trop de pauses café et debugging.',
        70, 'OR8'),

       ('Optimisation synaptique',
        'Amélioration de la transmission neuronale pour prévenir les Stack Overflow Syndrome.',
        80, 'OR9'),

       ('Test unitaire du genou',
        'Intervention préventive pour assurer la stabilité des articulations après trop de réunions.',
        35, 'OR10');





INSERT INTO users (id, email, password, firstname, lastname)
VALUES ('005d5657-3a8f-4132-a038-518a4bf7896f', 'hugo.tartempion@hospital.test', 'password123', 'Hugo', 'Tartempion'),
       ('1a2c9d13-75ef-449a-b979-bc4c861431d5', 'lola.biscotte@hospital.test', 'password123', 'Lola', 'Biscotte'),
       ('1c0b6011-b42e-49bb-944a-70748fa428cb', 'marcel.patate@hospital.test', 'password123', 'Marcel', 'Patate'),
       ('2190df70-33cf-4afa-8fb1-bfef2cdd9b8a', 'simone.croquette@hospital.test', 'password123', 'Simone', 'Croquette'),
       ('2a93a5b8-83c2-40f3-bca5-0d01eb02d8af', 'gustave.marmotte@hospital.test', 'password123', 'Gustave', 'Marmotte'),
       ('3013faa6-8ba4-4f2f-a6f6-35f14b9ee273', 'claude.fromage@hospital.test', 'password123', 'Claude', 'Fromage'),
       ('3eb8cc76-5db9-409a-9223-e34429dc50bf', 'betty.biscuit@hospital.test', 'password123', 'Betty', 'Biscuit'),
       ('4a7acfe5-3707-4a8a-9a02-973d3ee73d6a', 'fredo.pamplemousse@hospital.test', 'password123', 'Fredo',
        'Pamplemousse'),
       ('4b49471b-a133-49cf-8364-cfd232bf239b', 'sophie.baguette@hospital.test', 'password123', 'Sophie', 'Baguette'),
       ('4ba50ab0-e7df-488c-a8fa-f47ecc810d43', 'arthur.champignon@hospital.test', 'password123', 'Arthur',
        'Champignon'),
       ('5981ea8d-132b-4ec5-a8b1-c28f9fc96b98', 'emilie.chaussette@hospital.test', 'password123', 'Emilie',
        'Chaussette'),
       ('8d8ae3dd-f7ee-4da8-b9ed-b0abac745b09', 'paul.farfadet@hospital.test', 'password123', 'Paul', 'Farfadet'),
       ('924db760-8fe9-4060-8031-3b9e1202fcee', 'cecile.carotte@hospital.test', 'password123', 'Cécile', 'Carotte'),
       ('9493a5f1-c195-4d3c-9982-50ac0a479f9a', 'louis.brocoli@hospital.test', 'password123', 'Louis', 'Brocoli'),
       ('b65f38ae-a08e-4a0a-88e4-913a9c2c21f3', 'nina.nounours@hospital.test', 'password123', 'Nina', 'Nounours'),
       ('b99bc4a3-c64e-468c-b70f-6b7652a12a7a', 'theo.tartine@hospital.test', 'password123', 'Théo', 'Tartine'),
       ('c4140a47-c217-4175-810d-26143798cf05', 'juliette.papillon@hospital.test', 'password123', 'Juliette',
        'Papillon'),
       ('e4fd962b-4f2d-44a5-99d1-5561cb89d3f8', 'maxime.cacahuete@hospital.test', 'password123', 'Maxime', 'Cacahuète'),
       ('e61ac709-6221-4b97-b248-2143f1fa70cb', 'amelie.potiron@hospital.test', 'password123', 'Amélie',
        'Potiron'), -- ADMIN
       ('f7e9a947-5fad-4dc7-adb6-90dd9e79d581', 'henri.toupie@hospital.test', 'password123', 'Henri', 'Toupie');

INSERT INTO doctors (user_id, speciality_id, office_number, license_number)
VALUES ('4ba50ab0-e7df-488c-a8fa-f47ecc810d43', 1, 'A101', 'LIC123456'),
       ('3013faa6-8ba4-4f2f-a6f6-35f14b9ee273', 2, 'B202', 'LIC654321'),
       ('2a93a5b8-83c2-40f3-bca5-0d01eb02d8af', 3, 'C303', 'LIC112233'),
       ('005d5657-3a8f-4132-a038-518a4bf7896f', 4, 'D404', 'LIC445566'),
       ('1a2c9d13-75ef-449a-b979-bc4c861431d5', 5, 'E505', 'LIC778899'),
       ('1c0b6011-b42e-49bb-944a-70748fa428cb', 6, 'F606', 'LIC990011'),
       ('2190df70-33cf-4afa-8fb1-bfef2cdd9b8a', 7, 'G707', 'LIC223344');

INSERT INTO patients (user_id, birthdate, gender, address, phone)
VALUES ('3eb8cc76-5db9-409a-9223-e34429dc50bf', '1990-05-15', 'F', '123 Rue de la Paix, 75000 Paris', '0123456789'),
       ('924db760-8fe9-4060-8031-3b9e1202fcee', '1985-08-22', 'F', '456 Avenue des Champs, 69000 Lyon', '0987654321'),
       ('5981ea8d-132b-4ec5-a8b1-c28f9fc96b98', '1992-11-30', 'F', '789 Boulevard du Midi, 13000 Marseille',
        '0147258369'),
       ('4a7acfe5-3707-4a8a-9a02-973d3ee73d6a', '1988-02-14', 'M', '321 Place de la République, 31000 Toulouse',
        '0192837465'),
       ('f7e9a947-5fad-4dc7-adb6-90dd9e79d581', '1995-03-01', 'M', '654 Route de la Liberté, 44000 Nantes',
        '0172638495'),
       ('c4140a47-c217-4175-810d-26143798cf05', '1993-07-20', 'F', '987 Allée des Fleurs, 67000 Strasbourg',
        '0162738495'),
       ('9493a5f1-c195-4d3c-9982-50ac0a479f9a', '1987-12-05', 'M', '159 Chemin des Étoiles, 34000 Montpellier',
        '0152637489'),
       ('e4fd962b-4f2d-44a5-99d1-5561cb89d3f8', '1991-04-10', 'M', '753 Impasse du Soleil, 59000 Lille', '0182736459'),
       ('b65f38ae-a08e-4a0a-88e4-913a9c2c21f3', '1994-09-25', 'F', '852 Quai des Brumes, 06000 Nice', '0135792468'),
       ('8d8ae3dd-f7ee-4da8-b9ed-b0abac745b09', '1989-06-18', 'M', '147 Rue des Lilas, 44000 Nantes', '0192837465'),
       ('4b49471b-a133-49cf-8364-cfd232bf239b', '1996-01-30', 'F', '258 Avenue des Roses, 75000 Paris', '0123456789'),
       ('b99bc4a3-c64e-468c-b70f-6b7652a12a7a', '1990-10-12', 'M', '369 Boulevard des Tulipes, 69000 Lyon',
        '0987654321');


INSERT INTO roles (name)
VALUES ('USER'),
       ('ADMIN'),
       ('DOCTOR'),
       ('PATIENT'),
       ('SECRETARY');

INSERT INTO user_roles (user_id, role_id)
VALUES ('4ba50ab0-e7df-488c-a8fa-f47ecc810d43', 3),
       ('3013faa6-8ba4-4f2f-a6f6-35f14b9ee273', 3),
       ('2a93a5b8-83c2-40f3-bca5-0d01eb02d8af', 3),
       ('005d5657-3a8f-4132-a038-518a4bf7896f', 3),
       ('1a2c9d13-75ef-449a-b979-bc4c861431d5', 3),
       ('1c0b6011-b42e-49bb-944a-70748fa428cb', 3),
       ('2190df70-33cf-4afa-8fb1-bfef2cdd9b8a', 3),
       ('3eb8cc76-5db9-409a-9223-e34429dc50bf', 4),
       ('924db760-8fe9-4060-8031-3b9e1202fcee', 4),
       ('5981ea8d-132b-4ec5-a8b1-c28f9fc96b98', 4),
       ('4a7acfe5-3707-4a8a-9a02-973d3ee73d6a', 4),
       ('f7e9a947-5fad-4dc7-adb6-90dd9e79d581', 4),
       ('c4140a47-c217-4175-810d-26143798cf05', 4),
       ('9493a5f1-c195-4d3c-9982-50ac0a479f9a', 4),
       ('e4fd962b-4f2d-44a5-99d1-5561cb89d3f8', 4),
       ('b65f38ae-a08e-4a0a-88e4-913a9c2c21f3', 4),
       ('8d8ae3dd-f7ee-4da8-b9ed-b0abac745b09', 4),
       ('4b49471b-a133-49cf-8364-cfd232bf239b', 4),
       ('b99bc4a3-c64e-468c-b70f-6b7652a12a7a', 4),
       ('b99bc4a3-c64e-468c-b70f-6b7652a12a7a', 5),
       ('e61ac709-6221-4b97-b248-2143f1fa70cb', 2);


INSERT INTO medical_records (patient_id, blood_group, height_cm, weight_kg)
VALUES ('3eb8cc76-5db9-409a-9223-e34429dc50bf', 'A+', 165, 60),
       ('924db760-8fe9-4060-8031-3b9e1202fcee', 'B-', 170, 70),
       ('5981ea8d-132b-4ec5-a8b1-c28f9fc96b98', 'O+', 160, 55),
       ('4a7acfe5-3707-4a8a-9a02-973d3ee73d6a', 'AB+', 180, 80),
       ('f7e9a947-5fad-4dc7-adb6-90dd9e79d581', 'A-', 175, 75),
       ('c4140a47-c217-4175-810d-26143798cf05', 'B+', 168, 65),
       ('9493a5f1-c195-4d3c-9982-50ac0a479f9a', 'O-', 172, 68),
       ('e4fd962b-4f2d-44a5-99d1-5561cb89d3f8', 'AB-', 178, 78),
       ('b65f38ae-a08e-4a0a-88e4-913a9c2c21f3', 'A+', 158, 50),
       ('8d8ae3dd-f7ee-4da8-b9ed-b0abac745b09', 'B-', 182, 85),
       ('4b49471b-a133-49cf-8364-cfd232bf239b', 'O+', 166, 62),
       ('b99bc4a3-c64e-468c-b70f-6b7652a12a7a', 'AB+', 174, 72);
